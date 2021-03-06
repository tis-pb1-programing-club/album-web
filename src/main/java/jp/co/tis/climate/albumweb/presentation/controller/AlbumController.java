package jp.co.tis.climate.albumweb.presentation.controller;

import jp.co.tis.climate.albumweb.application.service.member.AlbumService;
import jp.co.tis.climate.albumweb.domain.model.member.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("album")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public String getAlbum(Model model) {
        model.addAttribute("profileCards", albumService.getProfileCards(new Profile(), 1));
        return "album/list";
    }

}
