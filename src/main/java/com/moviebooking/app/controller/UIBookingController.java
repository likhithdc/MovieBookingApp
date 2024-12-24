package com.moviebooking.app.controller;

import com.moviebooking.app.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UIBookingController {

    private final BookingService bookingService;

    public UIBookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking/create")
    public String createBooking(@RequestParam("movieId") Long movieId, RedirectAttributes redirectAttributes) {
        bookingService.createBooking(movieId);
        redirectAttributes.addFlashAttribute("message", "Ticket booked successfully!");
        return "redirect:/movies";
    }

}