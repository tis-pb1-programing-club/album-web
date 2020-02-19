package jp.co.tis.climate.albumweb.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class AccountController {

    @GetMapping
    @RequestMapping("new")
    public String accountNew(Model model) {
        return "account/new";
    }
}
