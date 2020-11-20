package geekbrains.lesson5.controller;

import geekbrains.lesson5.domain.ProductinShop;
import geekbrains.lesson5.domain.User;
import geekbrains.lesson5.service.ProductService;
import geekbrains.lesson5.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    private final UserService userService;

    public IndexController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "It's my First Online-Shop");
        return "index";
    }

    @RequestMapping(value = "/users")
    public String usersPage(Model model){
        List<User> user = userService.getAll();
        model.addAttribute("users", user);
        return "users";
    }

    @RequestMapping(value = "/login")
    public String loginPage(){
        return "login";
    }
}
