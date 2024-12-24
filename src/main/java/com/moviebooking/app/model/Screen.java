package com.moviebooking.app.model;

import com.moviebooking.app.service.Cinema;
import jakarta.persistence.*;


@Entity
@NamedQuery(name = "Screen.findByType", query = "SELECT s FROM Screen s WHERE s.type=:type")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @OneToOne
    private Movie movie;

    @ManyToOne
    private PVR pvrCinema;

    @ManyToOne
    private Innox innoxCinema;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public PVR getPvrCinema() {
        return pvrCinema;
    }

    public void setPvrCinema(PVR pvrCinema) {
        this.pvrCinema = pvrCinema;
    }

    public Innox getInnoxCinema() {
        return innoxCinema;
    }

    public void setInnoxCinema(Innox innoxCinema) {
        this.innoxCinema = innoxCinema;
    }

}