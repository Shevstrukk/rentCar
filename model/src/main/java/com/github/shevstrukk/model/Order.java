package com.github.shevstrukk.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private int rentDay;
    private int priceSum;
    private java.time.LocalDateTime date;
    private User user;
    private List<Car> carList;

    public Order(int rentDay, int priceSum, LocalDateTime date, List<Car> carList) {
        this.rentDay = rentDay;
        this.priceSum = priceSum;
        this.date = date;
        this.carList = carList;
    }

    public Order(Long id, int rentDay,
                 int priceSum, LocalDateTime date,
                 User user, List<Car> carList) {
        this.id = id;
        this.rentDay = rentDay;
        this.priceSum = priceSum;
        this.date = date;
        this.user = user;
        this.carList = carList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRentDay() {
        return rentDay;
    }

    public void setRentDay(int rentDay) {
        this.rentDay = rentDay;
    }

    public int getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(int priceSum) {
        this.priceSum = priceSum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
