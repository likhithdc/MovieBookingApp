package com.moviebooking.app.model;

import com.moviebooking.app.service.Cinema;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class PVR implements Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}