package jp.co.tis.climate.albumweb.controller;

import jp.co.tis.climate.albumweb.dto.UserPage;
import jp.co.tis.climate.albumweb.form.CareerForm;
import jp.co.tis.climate.albumweb.form.UserForm;
import jp.co.tis.climate.albumweb.model.Career;
import jp.co.tis.climate.albumweb.model.User;
import jp.co.tis.climate.albumweb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 経歴番号の初期値
     */
    static final String FIRST_CAREER_ID = "1";

    @Autowired
    private UserService userService;

    @GetMapping(path = "/view")
    public String view(@RequestParam("userId") String albumId,  Model model) {
        UserPage userPage = userService.getPersonalPageByPersonalId(albumId); // albumIdがないとエラー
        model.addAttribute("user", userPage.getUser());
        model.addAttribute("histories", userPage.getHistories());
        return "user/view";
    }

    @ModelAttribute
    @GetMapping(path="/edit")
    public String add(Model model){
        UserForm userForm = new UserForm();

        List<CareerForm> histories = new ArrayList<>();
        CareerForm career = new CareerForm();
        career.setCareerId(FIRST_CAREER_ID);
        histories.add(career);
        userForm.setHistories(histories);

        model.addAttribute("userForm",userForm);

        return "user/edit";
    }

    @RequestMapping(value = "edit", params = "addCareer", method = RequestMethod.POST)
    public String addCareer(@ModelAttribute("userForm") UserForm userForm, Model model){
        List<CareerForm> histories = userForm.getHistories();
        String careerId =String.valueOf(histories.size() + 1);

        CareerForm career = new CareerForm();
        career.setCareerId(careerId);
        histories.add(career);
        userForm.setHistories(histories);

        model.addAttribute("userForm",userForm);

        return "user/edit";
    }
    
    @RequestMapping(value = "edit", params = "addImage", method = RequestMethod.POST)
    public String addProfileImage(@ModelAttribute("userForm") UserForm userForm, @RequestParam("profileImage") MultipartFile mpf, Model model){
    	if(mpf.isEmpty()) {
    		model.addAttribute("userForm",userForm);
    		return "user/edit";
    	}

    	String profileImageFilename = userForm.getProfileImageFilename();
    	System.out.println(profileImageFilename);
        if(profileImageFilename.isEmpty()) {
        	//d初回の追加時はIDも不明なので、一意なファイル名を付けるために時刻を採用
        	//dこのファイル名で、各々のプロフィール画像を識別する
        	//TODO: 時刻ではなく、別のID採番方法？でファイル名を付けたい
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_nnnnnnnnn");
        	String uploadedDateTimeStr = LocalDateTime.now().format(formatter);
        	profileImageFilename = uploadedDateTimeStr + ".jpg";
        }

        try {
        	//TODO: 画像の保存先をapplication.ymlに外だしする
        	File uploadFile = new File("/static/image/" + profileImageFilename);
        	byte[] bytes = mpf.getBytes();
        	BufferedOutputStream uploadFileStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
        	uploadFileStream.write(bytes);
        	uploadFileStream.close();
        } catch (IOException e) {
        	//TODO: IOException発生時の挙動を実装する
    		model.addAttribute("userForm",userForm);
    		return "user/edit";
        }

        userForm.setProfileImageFilename(profileImageFilename);

        model.addAttribute("userForm",userForm);

        return "user/edit";
    }
   


    @RequestMapping(value = "edit", params = "submit", method = RequestMethod.POST)
    public String submit(@ModelAttribute("userForm") @Validated UserForm userForm, BindingResult result, Model model){
        if(result.hasErrors()){
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getField() + " : " + error.getDefaultMessage());
            }
            return "user/edit";
        }

        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userForm, User.class);
        String userId = user.getUserId();
        if (userService.isRegisteredUser(userId)) {
        	String errorMessage = "userId \"" + userId + "\" already exists.";
        	model.addAttribute("alreadyExistUserError",errorMessage);
        	return "user/edit";
        }

        List<Career> histories = userForm.getHistories().stream()
        		.filter(h -> h.getEvent() != null)
        		.map(h -> {
        			Career career = modelMapper.map(h, Career.class);
        			career.setUserId(userForm.getUserId());
        			return career;
        		}).collect(Collectors.toList());

        userService.register(user,histories);
        return "redirect:/";
    }
}
