package com.moviebooking.app.controller;

import com.moviebooking.app.Config.CustomUserDetails;
import com.moviebooking.app.model.Movie;
import com.moviebooking.app.model.User;
import com.moviebooking.app.repository.UserRepository;
import com.moviebooking.app.service.BookingService;
import com.moviebooking.app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Controller
public class AppContoller {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String getHomePage(Model model) {
        return "index";
    }

    @Autowired
    private MovieService movieService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegUser(User user, Model model, RedirectAttributes redirectAttributes, @Autowired @AuthenticationPrincipal Principal principal) {
        User existUser = userRepository.findByEmail(user.getEmail());
        if (existUser != null) {
            model.addAttribute("errorMessage", "Email " + user.getEmail() + " already exists. Please use a different email or login.");
            return "signup_form";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPass = encoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        userRepository.saveUser(user.getName(), user.getEmail(), user.getPassword());
        model.addAttribute("email", user.getEmail());
        return "register_success";
    }

    @GetMapping("/list_users")
    public String getListUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("listUsers", users);
        return "users";
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userDetails(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        System.out.println("--------------" + userDetails.toString());
        model.addAttribute("user", userDetails);
        return "userDetails";
    }

    @GetMapping("/movies")
    public String getAllMovies(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("movies", movieService.getAllMovies());
        User user = userRepository.findByEmail(userDetails.getUsername());
        if (user != null) {
            model.addAttribute("user", user);
        } else {
            throw new RuntimeException("User not found");
        }
        return "movies";
    }

}