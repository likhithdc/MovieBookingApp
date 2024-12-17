package com.moviebooking.app.controller;

import com.moviebooking.app.model.Movie;
import com.moviebooking.app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Add a new movie
    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully!");
    }

    // Get all movies
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    //update moview time
    @PutMapping("/update/{id}/timing")
    public ResponseEntity<String> updateMovieTiming(@PathVariable Long id, @RequestBody String newShowCyle) {
        movieService.updateMovieTiming(id, newShowCyle);
        return ResponseEntity.ok("Movie timing updated successfully!");
    }

    // Update movie details
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        movieService.updateMovie(id, movie);
        return ResponseEntity.ok("Movie updated successfully!");
    }

    // Delete a movie
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully!");
    }

}