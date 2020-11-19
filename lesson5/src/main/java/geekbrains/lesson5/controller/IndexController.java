package geekbrains.lesson5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "It's my First Online-Shop");
        return "index";
    }
    @RequestMapping(value = "/login")
    public String loginPage(){
        return "login";
    }
}
