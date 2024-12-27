package com.moviebooking.app.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_User_Booking"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "FK_Movie_Booking"))
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "cinema_id", foreignKey = @ForeignKey(name = "FK_Cinema_Booking"))
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "screen_id", foreignKey = @ForeignKey(name = "FK_Screen_Booking"))
    private Screen screen;

    @Column(nullable = false)
    private LocalDateTime bookingDateTime;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

}