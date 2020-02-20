package jp.co.tis.climate.albumweb.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {

    @GetMapping("/top")
    public String top(Model model) {

        return "top";
    }

    @GetMapping("/profile/list")
    public String list() {

        return "top";
    }

}

