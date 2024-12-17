package com.moviebooking.app.service;

import com.moviebooking.app.model.Movie;
import com.moviebooking.app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    // Fetch all movies

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Find movie by ID
    public Optional<Movie> getMovieById(Long movieId) {
        return Optional.ofNullable(movieRepository.findById(movieId).orElseThrow(() -> new IllegalArgumentException("Movie with ID" + movieId + "not found")));
    }

    // Add a new movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Update movie timings
    public Movie updateMovieTiming(Long movieId, String newShowCycle) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            movie.setShowCycle(newShowCycle);
            return movieRepository.save(movie);
        } else {
            throw new IllegalArgumentException("Movie with Id" + movieId + "Not found");
        }
    }

    public void deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Movie with Id " + id + "not found");
        }
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setGenre(updatedMovie.getGenre());
            movie.setDirector(updatedMovie.getDirector());
            movie.setShowCycle(updatedMovie.getShowCycle());
            movie.setDuration(updatedMovie.getDuration());
            movie.setLanguage(updatedMovie.getLanguage());
            return movieRepository.save(movie);
        } else {
            throw new IllegalArgumentException(("Movie with Id" + id + " not found"));
        }
    }

}