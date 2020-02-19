package jp.co.tis.climate.albumweb.presentation.controller.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class DetailController {
    @GetMapping("/{id}")
    public String detail(@PathVariable("id") String employeeId){
        return "profile/detail";
    }
}
