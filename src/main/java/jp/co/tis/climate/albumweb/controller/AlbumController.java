package jp.co.tis.climate.albumweb.controller;

import jp.co.tis.climate.albumweb.model.User;
import jp.co.tis.climate.albumweb.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(path="/")
    public String getAlbum(Model model){
        model.addAttribute("userParts", albumService.getPersonalParts(new User(), 1));
        return "/album/list";
    }
}
