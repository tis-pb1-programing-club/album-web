package jp.co.tis.climate.albumweb.presentation.controller;

import jp.co.tis.climate.albumweb.domain.model.profile.Profile;
import jp.co.tis.climate.albumweb.application.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public String getAlbum(Model model) {
        model.addAttribute("profileCards", albumService.getProfileCards(new Profile(), 1));
        return "album/list";
    }

}
