package jp.co.tis.climate.albumweb.controller;

import jp.co.tis.climate.albumweb.dto.PersonalPage;
import jp.co.tis.climate.albumweb.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


}
