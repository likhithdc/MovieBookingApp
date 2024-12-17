package com.moviebooking.app.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@MappedSuperclass

public abstract class BaseEntity {

    @Column(updatable = false)

    private LocalDateTime createdDate;


    private LocalDateTime updatedDate;


    @PrePersist

    public void prePersist() {

        this.createdDate = LocalDateTime.now();

        this.updatedDate = LocalDateTime.now();

    }


    @PreUpdate

    public void preUpdate() {

        this.updatedDate = LocalDateTime.now();

    }


    // Getters and Setters

    public LocalDateTime getCreatedDate() {

        return createdDate;

    }


    public void setCreatedDate(LocalDateTime createdDate) {

        this.createdDate = createdDate;

    }


    public LocalDateTime getUpdatedDate() {

        return updatedDate;

    }


    public void setUpdatedDate(LocalDateTime updatedDate) {

        this.updatedDate = updatedDate;

    }
}