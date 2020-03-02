package jp.co.tis.climate.albumweb.presentation.controller;

import jp.co.tis.climate.albumweb.domain.code.BloodType;
import jp.co.tis.climate.albumweb.domain.code.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {

    @GetMapping("/top")
    public String top(Model model) {

        topCommonModelAttribute(model);
        return "top";
    }

    @GetMapping("/profile/list")
    public String list() {

        return "top";
    }

    private void topCommonModelAttribute(Model model){
        model.addAttribute("cities", City.values());
        model.addAttribute("bloodTypeList", BloodType.values());
    }

}

