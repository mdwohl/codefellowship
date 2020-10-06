package com.mdwohl.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String renderHomepage(){
        System.out.println("Rendering homepage");
        return "home";
    }
}
