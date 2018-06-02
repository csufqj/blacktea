package fqj.csu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/reg"})
    public String reg() {
        return "reg";
    }

    @RequestMapping({"/login"})
    public String login() {
        return "login";
    }

}



