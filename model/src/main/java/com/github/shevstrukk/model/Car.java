package com.github.Shevstrukk.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private Integer id;
    private String carName;
    private int carYear;
    private  String carColor;
    private  int priceDay;
    private String comment;
    private List<Order> orders = new ArrayList<>();

    public Car(Integer id, String carName, int carYear,
               String carColor, int priceDay, String comment, List<Order> orders) {
        this.id = id;
        this.carName = carName;
        this.carYear = carYear;
        this.carColor = carColor;
        this.priceDay = priceDay;
        this.comment = comment;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarYear() {
        return carYear;
    }

    public String getCarColor() {
        return carColor;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public String getComment() {
        return comment;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
