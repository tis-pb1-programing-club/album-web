package jp.co.tis.climate.albumweb.presentation.controller.admin;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class EditController {

    private final ModelMapper modelMapper;

    public EditController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping("edit")
    public String edit(Model model) {
        return "account/list";
    }



}
