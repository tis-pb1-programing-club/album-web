package jp.co.tis.climate.albumweb.presentation.controller.account;

import jp.co.tis.climate.albumweb.application.service.profile.ProfileService;
import jp.co.tis.climate.albumweb.presentation.dto.User;
import jp.co.tis.climate.albumweb.presentation.form.UserSearchForm;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class ListController {

    private final ProfileService profileService;

    public ListController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/list")
    public ModelAndView list(@Validated UserSearchForm form)
    {
        List<User> userList = profileService.findUser(form.getEmployeeId(), form.getName(), form.getAdmin());
        ModelAndView model = new ModelAndView();
        model.addObject("userList", userList);
        model.setViewName("account/list");
        return model;
    }

}
