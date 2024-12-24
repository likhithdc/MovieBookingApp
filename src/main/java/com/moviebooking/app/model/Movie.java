package com.moviebooking.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate releaseDate;

    private String showCycle;

    public Movie() {
    }

    public Movie(String title, LocalDate releaseDate, String showCycle) {
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

}