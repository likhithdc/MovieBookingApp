package com.moviebooking.app.controller;

import com.moviebooking.app.model.User;
import com.moviebooking.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppContoller {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String getHomePage(Model model)
    {
        return "index";
    }
    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegUser(User user) {
        userRepository.save(user);
        return "register_success";
    }

}