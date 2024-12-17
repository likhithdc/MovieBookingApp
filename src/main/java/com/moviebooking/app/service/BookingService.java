package com.moviebooking.app.service;

import com.moviebooking.app.model.Booking;
import com.moviebooking.app.model.Movie;
import com.moviebooking.app.repository.BookingRepository;
import com.moviebooking.app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MovieRepository movieRepository;

    // Create a booking

    public Booking createBooking(Long movieId, String userName) {

        Optional<Movie> movieOptional = movieRepository.findById(movieId);

        if (movieOptional.isPresent()) {

            Movie movie = movieOptional.get();

            Booking booking = new Booking(userName, movie);

            return bookingRepository.save(booking);

        } else {
            throw new IllegalArgumentException("booking with id" + movieId + "not found");
        }
    }


    // Cancel a booking

    public boolean cancelBooking(Long bookingId) {

        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);

        if (bookingOptional.isPresent()) {

            bookingRepository.delete(bookingOptional.get());

            return true;

        } else {
            throw new IllegalArgumentException("booking with id" + bookingId + "not found");
        }

    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public void updateBookingTime(Long id, String newShowTime) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setShowTime(newShowTime);
            bookingRepository.save(booking);
        } else {
            throw new IllegalArgumentException("booking with id" + id + "not found");
        }
    }

    public boolean deleteBooking(Long bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);

        if (bookingOptional.isPresent()) {

            bookingRepository.delete(bookingOptional.get());

            return true;

        } else {
            throw new IllegalArgumentException("booking with id" + bookingId + "not found");
        }

    }

    public Booking getBookingsById(Long bookingId) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);

        if (bookingOptional.isPresent()) {
            return bookingOptional.get();

        } else {
            throw new IllegalArgumentException("booking with id" + bookingId + "not found");
        }
    }
}
