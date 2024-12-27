package com.moviebooking.app.controller;

import com.moviebooking.app.model.Booking;
import com.moviebooking.app.model.Movie;
import com.moviebooking.app.repository.BookingRepository;
import com.moviebooking.app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Movie>> getBookingByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getMoviesByUserId(userId));
    }

    @PostMapping("/create/{userId}/{movieId}")
    public ResponseEntity<String> bookMovie(@PathVariable String userId, @PathVariable String movieId) {
        try {
            Long uId = Long.parseLong(userId);
            Long mId = Long.parseLong(movieId);
            bookingService.createBooking(uId, mId);
            return ResponseEntity.ok("Movie booked successfully!");
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid userId or movieId format: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to book the movie: " + e.getMessage());
        }
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long bookingId) {
        try {
            bookingService.cancelBooking(bookingId);
            return ResponseEntity.accepted().body("Deleted booking successfully");
        } catch (Exception e) {
            System.out.println("Booking ID not found: " + bookingId);
            return ResponseEntity.badRequest().body("Failed to cancel the booking" + e.getMessage());
        }

    }

}