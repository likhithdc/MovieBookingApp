package com.moviebooking.app.repository;

import com.moviebooking.app.model.Booking;
import com.moviebooking.app.model.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT new com.moviebooking.app.model.Movie(m.id,m.title, m.releaseDate, m.showCycle) FROM Booking b JOIN b.movie m WHERE b.user.id = :userId")
    List<Movie> findMoviesByUserId(@Param("userId") Long userId);

    @Query("SELECT b FROM Booking b WHERE b.user.id = :userId")
    List<Booking> findByUserId(@Param("userId") Long userId);


    @Modifying
    @Transactional
    @Query("DELETE FROM Booking b WHERE b.movie.id = :movieId")
    int deleteBookingsByMovieId(@Param("movieId") Long movieId);

    Optional<Booking> findByMovieId(Long bookingId);

}