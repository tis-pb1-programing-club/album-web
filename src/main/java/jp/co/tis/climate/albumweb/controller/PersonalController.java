package jp.co.tis.climate.albumweb.controller;

import jp.co.tis.climate.albumweb.dto.PersonalPage;
import jp.co.tis.climate.albumweb.form.CareerForm;
import jp.co.tis.climate.albumweb.form.UserForm;
import jp.co.tis.climate.albumweb.model.Career;
import jp.co.tis.climate.albumweb.model.User;
import jp.co.tis.climate.albumweb.service.PersonalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping(path = "/view")
    public String view(@RequestParam("userId") Integer albumId,  Model model) {
        PersonalPage personalPage = personalService.getPersonalPageByPersonalId(albumId); // albumIdがないとエラー
        model.addAttribute("user", personalPage.getUser());
        model.addAttribute("histories", personalPage.getHistories());
        return "user/view";
    }

    @GetMapping(path="add")
    public String add(Model model){
        List<CareerForm> histories = new ArrayList<>();
        for(int i =0 ; i <5;i++){
            CareerForm careerForm = new CareerForm();
            histories.add(careerForm);
        }

        model.addAttribute("histories", histories);
        return "user/add";
    }

    @PostMapping(path="submit")
    public String submit(@ModelAttribute("UserForm") UserForm userForm, Model model){
        ModelMapper modelMapper = new ModelMapper();

        User user = new User();
        modelMapper.map(userForm, user);

        List<Career> histories = new ArrayList<>();
        for(CareerForm careerForm : userForm.getHistories()){
            Career career = new Career();
            modelMapper.map(careerForm, career);
            histories.add(career);
        }

        personalService.register(user,histories);
        return "user/add";
    }


}
