package com.mdwohl.codefellowship.controllers;

import com.mdwohl.codefellowship.models.user.ApplicationUser;
import com.mdwohl.codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Date;

@Controller
public class UserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public RedirectView createUser(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam Date dob,
                                   @RequestParam String bio) {

        password = passwordEncoder.encode(password);


        ApplicationUser createUser = new ApplicationUser(username, password, firstName, lastName, dob, bio);
        applicationUserRepository.save(createUser);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                createUser, null, createUser.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);

        return new RedirectView("/userdetail");
    }
    @GetMapping("/userdetail")
    public String getUser(Principal p, Model m){
        try {
            ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("displayedUser", currentUser);
        } catch(Exception e){
            System.out.println(e);
        }
        return "userdetail";
    }

    @GetMapping("/login")
    public String getLogin(Principal p, Model m) {
        try {
            ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
            if (currentUser != null) {
                new RedirectView("/userdetail");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(57);
        }
        return "login";
    }

    @GetMapping("/signup")
    public String getSignup(Principal p, Model m) {
        try {
            ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
            if (currentUser != null) {
                new RedirectView("/userdetail");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(72);
        }
        return "signup";
    }
}