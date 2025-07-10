package spring_duck.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.PublicKey;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home () {
        return "home";
    }
}
