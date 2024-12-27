package com.moviebooking.app.service;

import com.moviebooking.app.model.*;
import com.moviebooking.app.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BookingService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScreenRepository screenRepository;

    public BookingService(BookingRepository bookingRepository, MovieRepository movieRepository, UserRepository userRepository, CinemaRepository cinemaRepository, ScreenRepository screenRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.screenRepository = screenRepository;
    }

    public List<Movie> getMoviesByUserId(Long userId) {
        return bookingRepository.findMoviesByUserId(userId);
    }

    public void createBooking(Long userId, Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        // Find the cinema and screen associated with the movie
        Screen screen = screenRepository.findByMovie(movie).orElseThrow(() -> new RuntimeException("Screen not found for the movie"));
        Cinema cinema = screen.getCinema();
        LocalDateTime bookingDateTime = LocalDateTime.now(); // Current date and time
        Booking booking = new Booking();
        booking.setMovie(movie);
        booking.setUser(user);
        booking.setCinema(cinema);
        booking.setScreen(screen);
        booking.setBookingDateTime(bookingDateTime);
        bookingRepository.save(booking);
    }

    @Transactional
    public void cancelBooking(Long bookingId) {
        int rowsAffected = bookingRepository.deleteBookingsByMovieId(bookingId);
        System.out.println("Rows affected: " + rowsAffected);
        if (rowsAffected > 0) {
            // Deletion was successful
            entityManager.flush();
            entityManager.clear();
        }
    }

}