package com.moviebooking.app.service;

import com.moviebooking.app.model.Booking;
import com.moviebooking.app.model.Movie;
import com.moviebooking.app.repository.BookingRepository;
import com.moviebooking.app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingService {

    @Autowired
    private final BookingRepository bookingRepository;

    @Autowired
    private final MovieRepository movieRepository;

    public BookingService(BookingRepository bookingRepository, MovieRepository movieRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void createBooking(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException(("Movie not found")));
        Booking booking = new Booking();
        booking.setMovie(movie);
        bookingRepository.save(booking);
    }

}