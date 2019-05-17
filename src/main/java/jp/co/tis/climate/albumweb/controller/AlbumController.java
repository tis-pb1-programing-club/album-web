package jp.co.tis.climate.albumweb.controller;

import jp.co.tis.climate.albumweb.model.Profile;
import jp.co.tis.climate.albumweb.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public String getAlbum(Model model){
        model.addAttribute("profileCards", albumService.getProfileCards(new Profile(), 1));
        return "album/list";
    }
    
}
