package com.moviebooking.app.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Screen screen;

    private LocalDate bookingDate;

}