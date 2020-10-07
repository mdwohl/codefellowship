package com.mdwohl.codefellowship.controllers;

import com.mdwohl.codefellowship.models.user.ApplicationUser;
import com.mdwohl.codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
@RequestMapping(value="/testPath")

public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user/{username}")
    public String showUserDetailsPage(@PathVariable String username, Model m){
        ApplicationUser user = applicationUserRepository.findByUsername(username);
        m.addAttribute("user", user);
        if(user == null){
//            throw new Exception("user not found");
            m.addAttribute("userDoesNotExist", true);
        }
        return "userdetail";
    }

//    @PostMapping("/signup")
//    public RedirectView createNewUser(String username, String password, String firstName, String lastName, int dob, String bio){
//        System.out.println("Add a new user");
//        password = passwordEncoder.encode(password);
//
//        ApplicationUser newUser = new ApplicationUser(username, password, firstName, lastName, dob, bio);
//
//        applicationUserRepository.save(newUser);
//
//        return new RedirectView("/");
//    }

    @GetMapping("/login")
    public String login (Principal p, Model m){
        m.addAttribute("Principal", p);
        return "login";
    }
}
