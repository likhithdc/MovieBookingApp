package com.moviebooking.app.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate releaseDate;

    private String showCycle;


    @OneToOne(mappedBy = "movie")
    private Screen screen;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;

    public Movie() {
    }

    public Movie(String title, LocalDate releaseDate, String showCycle) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.showCycle = showCycle;
    }
    public Movie(Long id, String title, LocalDate releaseDate, String showCycle) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.showCycle = showCycle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

}