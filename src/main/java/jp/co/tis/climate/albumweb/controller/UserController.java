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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/view")
    public String view(@RequestParam("userId") Integer albumId,  Model model) {
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
        career.setCareerId("1");
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

    @RequestMapping(value = "edit", params = "submit", method = RequestMethod.POST)
    public String submit(@ModelAttribute("userForm") @Validated UserForm userForm, BindingResult result, Model model){
        if(result.hasErrors()){
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getField() + " : " + error.getDefaultMessage());
            }
            return "user/edit";
        }

        ModelMapper modelMapper = new ModelMapper();

        User user = new User();
        modelMapper.map(userForm, user);

        List<Career> histories = new ArrayList<>();

        for(CareerForm careerForm : userForm.getHistories()){
            // 経歴の内容に記入がない行はDB登録しない。
            if(careerForm.getEvent() != null) {
                Career career = new Career();
                modelMapper.map(careerForm, career);
                career.setUserId(userForm.getUserId());
                histories.add(career);
            }
        }

        userService.register(user,histories);
        return "forward:/";
    }
}
