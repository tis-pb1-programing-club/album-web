package jp.co.tis.climate.albumweb.controller;

import jp.co.tis.climate.albumweb.dto.AlbumPage;
import jp.co.tis.climate.albumweb.model.Hello;
import jp.co.tis.climate.albumweb.service.AlbumViewService;
import jp.co.tis.climate.albumweb.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/album")
public class AlbumViewController {

    @Autowired
    private AlbumViewService albumViewService;

    @GetMapping(path = "/album")
    public String getHello(Model model) {
        AlbumPage albumPage = albumViewService.getAlbumPageById(0);
        model.addAttribute("employeeAlbum", albumPage.getEmployeeAlbum());
        model.addAttribute("histories", albumPage.getHistories());
        return "album/album";
    }
}
