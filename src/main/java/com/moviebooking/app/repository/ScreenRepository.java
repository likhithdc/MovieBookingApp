package com.moviebooking.app.repository;

import com.moviebooking.app.model.Movie;
import com.moviebooking.app.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {

    List<Screen> findByType(String type);
    Optional<Screen> findByMovie(Movie movie);

}