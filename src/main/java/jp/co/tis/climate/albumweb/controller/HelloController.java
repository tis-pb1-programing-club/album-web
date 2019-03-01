package jp.co.tis.climate.albumweb.controller;

import jp.co.tis.climate.albumweb.model.Hello;
import jp.co.tis.climate.albumweb.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping
    public String getHello(Model model) {
        String message = helloService.getHello().orElse(new Hello()).getMessage();
        model.addAttribute("message", message);
        return "hello";
    }
}
