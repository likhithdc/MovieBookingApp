package com.moviebooking.app.controller;

import com.moviebooking.app.model.Movie;
import com.moviebooking.app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class UIController {

    @Autowired
    private MovieService movieService;

    // Redirect to the Home Page
    @GetMapping("/")
    public String home() {
        return "index"; // Redirects to src/main/resources/templates/index.html
    }

    // Redirect to the Login Page
    @GetMapping("/login")
    public String login() {
        return "login"; // Redirects to src/main/resources/templates/login.html
    }

    // Redirect to the Registration Page
    @GetMapping("/register")
    public String register() {
        return "register"; // Redirects to src/main/resources/templates/register.html
    }

    // Show all Movies (Movies Page)
    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies); // Pass movie list to the view
        return "movies"; // Redirects to src/main/resources/templates/movies.html
    }

    // Redirect to the Booking Page
    @GetMapping("/bookings")
    public String bookings() {
        return "bookings"; // Redirects to src/main/resources/templates/bookings.html
    }

    // Redirect to the Admin Dashboard
    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin"; // Redirects to src/main/resources/templates/admin.html
    }

}