package jp.co.tis.climate.albumweb.presentation.controller;

import jp.co.tis.climate.albumweb.application.service.profile.ProfileSearchService;
import jp.co.tis.climate.albumweb.domain.Hobby;
import jp.co.tis.climate.albumweb.domain.Name;
import jp.co.tis.climate.albumweb.domain.code.City;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.presentation.form.ProfileSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/** トップ画面のコントローラ */
@Controller
public class TopController {

    private final ProfileSearchService profileSearchService;

    public TopController(ProfileSearchService profileSearchService) {
        this.profileSearchService = profileSearchService;
    }

    // 常にformを返す
    @ModelAttribute
    ProfileSearchForm setupForm() {
        return new ProfileSearchForm();
    }

    /** top画面初期表示 */
    @GetMapping("/top")
    public String top(Model model) {
        List<Profile> searchResult = profileSearchService.searchProfile(new Profile());
        // TODO: 顔写真をhtmlで表示できるようにはしてない
        model.addAttribute("searchResult", searchResult);
        topCommonModelAttribute(model);
        return "top";
    }

    /** top画面検索表示 */
    // TODO: 都道府県の検索がうまくいっていない
    @GetMapping("/profile/list")
    public String list(@Validated ProfileSearchForm profileSearchForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            topCommonModelAttribute(model);
            return "top";
        }
        // formをdomainに詰め替える
        // 同じようなことする処理が世の中にありそうだけどわかんなかった。
        Profile profile = new Profile();
        profile.setName(new Name(profileSearchForm.getName()));
        profile.setHobby(new Hobby(profileSearchForm.getHobby()));
        profile.setBirthplace(City.of(profileSearchForm.getBirthplaceId()));
        // teamの処理
        List<Profile> searchResult = profileSearchService.searchProfile(profile);
        model.addAttribute("searchResult", searchResult);
        topCommonModelAttribute(model);
        return "top";
    }

    /** top画面共通後処理 */
    private void topCommonModelAttribute(Model model) {
        model.addAttribute("cities", City.values());
    }

}

