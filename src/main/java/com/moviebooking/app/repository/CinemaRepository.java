package com.moviebooking.app.repository;

import com.moviebooking.app.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}