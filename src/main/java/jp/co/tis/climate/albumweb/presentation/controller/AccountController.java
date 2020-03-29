package jp.co.tis.climate.albumweb.presentation.controller;

import jp.co.tis.climate.albumweb.application.service.account.AccountService;
import jp.co.tis.climate.albumweb.application.service.team.TeamService;
import jp.co.tis.climate.albumweb.domain.model.member.Team;
import jp.co.tis.climate.albumweb.presentation.form.ProfileForm;
import jp.co.tis.climate.albumweb.presentation.form.TeamForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.tis.climate.albumweb.domain.code.BloodType;
import jp.co.tis.climate.albumweb.domain.code.City;
import jp.co.tis.climate.albumweb.domain.code.Gender;
import jp.co.tis.climate.albumweb.domain.code.Recruit;

@Controller
@RequestMapping("account")
public class AccountController {

    private final TeamService teamService;

    public AccountController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/new")
    public ModelAndView display(Model viewModel) {
    	ModelAndView model = new ModelAndView();
    	model.addObject("bloodTypeList", BloodType.values());
    	model.addObject("cityList", City.values());
    	model.addObject("recruitList", Recruit.values());
    	model.addObject("genderList", Gender.values());
        Iterable<Team> teamList = teamService.findTeamList();
        viewModel.addAttribute("teamList", teamList);
    	model.setViewName("account/new");
    	//初期表示のためにFormのインスタンスを渡す（これがないと表示されない）
    	model.addObject("profileForm", new ProfileForm());
        return model;
    }

    @PostMapping("/new")
    public String registration(Model model) {
        return "top";
    }

}
