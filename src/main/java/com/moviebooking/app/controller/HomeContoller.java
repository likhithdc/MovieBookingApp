package com.moviebooking.app.controller;

import com.moviebooking.app.model.Movie;
import com.moviebooking.app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeContoller {

    @Autowired
    private MovieService movieService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

}