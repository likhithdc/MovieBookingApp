package com.moviebooking.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity

@Table(name = "movies")
public class Movie {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @Column(nullable = false)

    private String title;

    @Column(nullable = false)

    private String duration;

    @Column(nullable = false)

    private String Language;

    @Column(nullable = false)

    private String genre;


    @Column(nullable = false)

    private String director;


    @Column(nullable = false)

    private String showCycle; // Show timings, e.g., "10:00 AM, 1:00 PM, 4:00 PM"


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Booking> bookings;


    // Getters and Setters

    public Long getId() {

        return id;

    }


    public void setId(Long id) {

        this.id = id;

    }


    public String getTitle() {

        return title;

    }


    public void setTitle(String title) {

        this.title = title;

    }


    public String getGenre() {

        return genre;

    }


    public void setGenre(String genre) {

        this.genre = genre;

    }


    public String getDirector() {

        return director;

    }


    public void setDirector(String director) {

        this.director = director;

    }


    public String getShowCycle() {

        return showCycle;

    }


    public void setShowCycle(String showCycle) {

        this.showCycle = showCycle;

    }


    public List<Booking> getBookings() {

        return bookings;

    }


    public void setBookings(List<Booking> bookings) {

        this.bookings = bookings;

    }


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }
}
