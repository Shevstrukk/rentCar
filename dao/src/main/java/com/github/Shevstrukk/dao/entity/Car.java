package com.github.Shevstrukk.dao.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "car_name")
    private String carName;
    @Column(name = "car_year")
    private int carYear;
    @Column(name = "car_color")
    private  String carColor;
    @Column(name = "price_day")
    private  int priceDay;
    @Column(name = "comment")
    private String comment;

    @ManyToMany(mappedBy = "cars", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    public Car() {    }

    public Car(Integer id, String carName, int carYear,
               String carColor, int priceDay, String comment, List< Order> orders) {
        this.id = id;
        this.carName = carName;
        this.carYear = carYear;
        this.carColor = carColor;
        this.priceDay = priceDay;
        this.comment = comment;
        this.orders= orders;
    }

    public Integer getId() {        return id;    }

    public void setId(Integer id) {        this.id = id;    }

    public String getCarName() {        return carName;    }

    public void setCarName(String carName) {        this.carName = carName;    }

    public int getCarYear() {        return carYear;    }

    public void setCarYear(int carYear) {        this.carYear = carYear;    }

    public String getCarColor() {        return carColor;    }

    public void setCarColor(String carColor) {        this.carColor = carColor;    }

    public int getPriceDay() {        return priceDay;    }

    public void setPriceDay(int priceDay) {        this.priceDay = priceDay;    }

    public String getComment() {        return comment;    }

    public void setComment(String comment) {        this.comment = comment;    }

    public List<Order> getOrders() {     return orders;    }

    public void setOrders(List<Order> orders) {        this.orders = orders;
    }

}
