package jp.co.tis.climate.albumweb.presentation.controller;

import jp.co.tis.climate.albumweb.application.service.profile.ProfileSearchService;
import jp.co.tis.climate.albumweb.domain.code.BloodType;
import jp.co.tis.climate.albumweb.domain.code.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {

    private final ProfileSearchService profileSearchService;

    public TopController(ProfileSearchService profileSearchService) {
        this.profileSearchService = profileSearchService;
    }

    @GetMapping("/top")
    public String top(Model model) {
        model.addAttribute("searchResult", profileSearchService.searchProfile());
        topCommonModelAttribute(model);
        return "top";
    }

    @GetMapping("/profile/list")
    public String list(Model model) {

        return "top";
    }

    private void topCommonModelAttribute(Model model) {
        model.addAttribute("cities", City.values());
        model.addAttribute("bloodTypeList", BloodType.values());
    }

}

