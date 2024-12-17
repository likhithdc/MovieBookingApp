package com.moviebooking.app.controller;

import com.moviebooking.app.model.Booking;
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

    // Create a booking
    @PostMapping("/add/{movieId}")
    public ResponseEntity<String> createBooking(@PathVariable Long movieId, @RequestBody String bookingName) {
        bookingService.createBooking(movieId, bookingName);
        return ResponseEntity.ok("Booking created successfully!");
    }

    // Cancel a booking
    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking canceled successfully!");
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Optional<Booking>> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingsById(bookingId);
        if (booking != null) {
            return ResponseEntity.ok(Optional.of(booking));
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Update booking timings
    @PutMapping("/{bookingId}/update-time")
    public ResponseEntity<String> updateBookingTime(@PathVariable Long id, @RequestParam String newShowTime) {
        bookingService.updateBookingTime(id, newShowTime);
        return ResponseEntity.ok("Booking updated successfully!");
    }

    @DeleteMapping("/{bookingId}/delete")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("booking deleted successfully");
    }


    // Get all bookings for a user

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.getBookingsByUser(userId);
        return ResponseEntity.ok(bookings);
    }
}