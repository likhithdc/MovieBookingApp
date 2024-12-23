package com.moviebooking.app.service;

import com.moviebooking.app.model.Booking;
import com.moviebooking.app.repository.BookingRepository;
import com.moviebooking.app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MovieRepository movieRepository;


    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking createBooking(Booking booking)
    {
        return bookingRepository.save(booking);
    }


}