package com.moviebooking.app;

import com.moviebooking.app.model.Movie;
import com.moviebooking.app.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class MovieInitializer implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public MovieInitializer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (movieRepository.count() == 0) {
            movieRepository.save(new Movie("Inception", LocalDate.of(2017, 7, 16), "Evening"));
            movieRepository.save(new Movie("The Dark Knight", LocalDate.of(2008, 7, 18), "Night"));
            movieRepository.save(new Movie("Interstellar", LocalDate.of(2008, 7, 18), "Morning"));
            movieRepository.save(new Movie("Avatar", LocalDate.of(2008, 7, 18), "Afternoon"));
            movieRepository.save(new Movie("The Matrix", LocalDate.of(2008, 7, 18), "Evening"));
        }
    }

}