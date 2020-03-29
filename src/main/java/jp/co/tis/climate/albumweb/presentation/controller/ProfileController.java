package jp.co.tis.climate.albumweb.presentation.controller;

import jp.co.tis.climate.albumweb.application.service.profile.ProfileService;
import jp.co.tis.climate.albumweb.domain.Name;
import jp.co.tis.climate.albumweb.domain.code.BloodType;
import jp.co.tis.climate.albumweb.domain.code.City;
import jp.co.tis.climate.albumweb.domain.code.Gender;
import jp.co.tis.climate.albumweb.domain.code.Recruit;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import jp.co.tis.climate.albumweb.presentation.form.ProfileForm;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    //teamのinsertも一旦スキップ　プロフィールだけやってみる
    //CareerService作らなきゃかもだけど一旦飛ばす
    //    private final Team team;
    //    private final TeamService teamService;

    private final ProfileService profileService;



    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
//        this.teamService = teamService;
//        this.team = team;
    }

    @ModelAttribute
    ProfileForm setUpForm() {
        return new ProfileForm();
    }

    @PostMapping("/account")
    public String registration(ProfileForm profileForm){
        //精査後回し
//       ⇒一括のやつうまくいかん org.springframework.beans.BeanUtils.copyProperties(teamForm, team);
//        org.springframework.beans.BeanUtils.copyProperties(profileForm, profile);
        Profile profile = new Profile();
        profile.setName(new Name(profileForm.getFullName()));
        profile.setRecruit(Recruit.of(profileForm.getRecruitId()));
        profile.setBirthplace(City.of(profileForm.getCityId()));
        profile.setGenderId(Gender.of(profileForm.getGenderId()));
        profile.setBloodTypeId(BloodType.of(profileForm.getBloodTypeId()));

        //debugもどき
        LogFactory.getLog(this.getClass()).debug(profile);
        System.out.print(profile);

        profileService.registar(profile);
        return "redirect:top";
    }
}
