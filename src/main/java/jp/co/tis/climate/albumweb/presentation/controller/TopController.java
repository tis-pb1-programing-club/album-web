package jp.co.tis.climate.albumweb.presentation.controller;

import jp.co.tis.climate.albumweb.application.service.profile.ProfileSearchService;
import jp.co.tis.climate.albumweb.domain.code.BloodType;
import jp.co.tis.climate.albumweb.domain.code.City;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/** トップ画面のコントローラ */
@Controller
public class TopController {

    private final ProfileSearchService profileSearchService;

    public TopController(ProfileSearchService profileSearchService) {
        this.profileSearchService = profileSearchService;
    }

    /** top画面初期表示 */
    @GetMapping("/top")
    public String top(Model model) {
        List<Profile> searchResult = profileSearchService.searchProfile(new Profile());
        /* TODO: 顔写真をhtmlで表示できるようにはしてない */
        model.addAttribute("searchResult", searchResult);
        topCommonModelAttribute(model);
        return "top";
    }

    /** top画面検索表示 */
    @GetMapping("/profile/list")
    public String list(Model model) {
        topCommonModelAttribute(model);
        return "top";
    }

    /** top画面共通後処理 */
    private void topCommonModelAttribute(Model model) {
        model.addAttribute("cities", City.values());
    }

}

