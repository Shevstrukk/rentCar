package com.github.shevstrukk.model;

import java.time.LocalDateTime;

public class RentalPeriod {
    private Long id;
    private java.time.LocalDateTime start;
    private java.time.LocalDateTime end;
    Car car;

    public RentalPeriod(Long id, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public RentalPeriod(Long id, LocalDateTime start, LocalDateTime end, Car car) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}