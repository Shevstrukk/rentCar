package com.github.shevstrukk.dao.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "rental_period")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RentalPeriodEntity {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="start")
    private java.time.LocalDateTime start;
    @Column(name="end")
    private java.time.LocalDateTime end;
    @ManyToOne
    @JoinColumn(name = "car_id")
//    @ManyToOne(optional=false, cascade=CascadeType.ALL)
//    @JoinColumn(name = "car_id")
            CarEntity car;

    public RentalPeriodEntity() {}

    public RentalPeriodEntity(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public RentalPeriodEntity(Long id, LocalDateTime start, LocalDateTime end, CarEntity car) {
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

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }
}
