package com.moviebooking.app.repository;

import com.moviebooking.app.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {

}