package com.moviebooking.app.service;

import com.moviebooking.app.model.Movie;
import com.moviebooking.app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    // Fetch all movies

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        return movieRepository.findById(id).map(movie -> {
            movie.setTitle(updatedMovie.getTitle());
            movie.setShowCycle(updatedMovie.getShowCycle());
            movie.setReleaseDate(updatedMovie.getReleaseDate());
            return movieRepository.save(movie);
        }).orElseThrow(() -> new RuntimeException("Movie not Found"));
    }

}