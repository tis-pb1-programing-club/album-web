package jp.co.tis.climate.albumweb.controller;

import jp.co.tis.climate.albumweb.dto.AlbumPage;
import jp.co.tis.climate.albumweb.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping(path = "/albumPage")
    public String getHello(@RequestParam("albumId") Integer albumId,  Model model) {
        AlbumPage albumPage = albumService.getAlbumPageById(albumId); // albumIdがないとエラー
        model.addAttribute("album", albumPage.getAlbum());
        model.addAttribute("histories", albumPage.getHistories());
        return "album/albumPage";
    }
}
