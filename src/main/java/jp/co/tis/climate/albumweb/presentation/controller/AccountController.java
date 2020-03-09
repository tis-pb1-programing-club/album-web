package jp.co.tis.climate.albumweb.presentation.controller;

import jp.co.tis.climate.albumweb.domain.model.member.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.tis.climate.albumweb.domain.code.BloodType;
import jp.co.tis.climate.albumweb.domain.code.City;
import jp.co.tis.climate.albumweb.domain.code.Gender;
import jp.co.tis.climate.albumweb.domain.code.Recruit;

@Controller
@RequestMapping("account")
public class AccountController {

    @GetMapping("/new")
    public ModelAndView display() {
    	ModelAndView model = new ModelAndView();
    	model.addObject("bloodTypeList", BloodType.values());
    	model.addObject("cityList", City.values());
    	model.addObject("recruitList", Recruit.values());
    	model.addObject("genderList", Gender.values());
    	model.setViewName("account/new");
        return model;
    }

    @PostMapping("/new")
    public String registration(Model model) {
        return "top";
    }

}
