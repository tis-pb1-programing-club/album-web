package jp.co.tis.climate.albumweb.controller;

import jp.co.tis.climate.albumweb.dao.PersonalDao;
import jp.co.tis.climate.albumweb.dto.PersonalPage;
import jp.co.tis.climate.albumweb.form.PersonalForm;
import jp.co.tis.climate.albumweb.model.Personal;
import jp.co.tis.climate.albumweb.service.PersonalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping(path = "/view")
    public String view(@RequestParam("personalId") Integer albumId,  Model model) {
        PersonalPage personalPage = personalService.getPersonalPageByPersonalId(albumId); // albumIdがないとエラー
        model.addAttribute("personal", personalPage.getPersonal());
        model.addAttribute("histories", personalPage.getHistories());
        return "personal/view";
    }

    @GetMapping(path="add")
    public String add(Model model){
        return "personal/add";
    }

    @PostMapping(path="submit")
    public String submit(@ModelAttribute("PersonalForm") PersonalForm personalForm, Model model){
        ModelMapper modelMapper = new ModelMapper();

        Personal personal = new Personal();
        modelMapper.map(personalForm,personal);
        personalService.register(personal);
        return "personal/add";
    }


}
