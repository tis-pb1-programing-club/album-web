package jp.co.tis.climate.albumweb.presentation.controller.account;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class ListController {

    private final ModelMapper modelMapper;

    public ListController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public String list(Model model) {
        return "account/list";
    }



}
