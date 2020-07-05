package com.github.shevstrukk.model;

import java.util.List;

public class Car {
    private Long id;
    private String carModel;
    private String carName;
    private int carYear;
    private String carColor;
    private String carFuel;
    private int priceDay;
    private String comment;
    private List<RentalPeriod> periods;
    private List<Order> orderList;

    public Car() { }

    public Car(Long id, String carModel, String carName, int carYear, String carColor, String carFuel,
               int priceDay, String comment, List<RentalPeriod> periods, List<Order> orderList) {
        this.id = id;
        this.carModel = carModel;
        this.carName = carName;
        this.carYear = carYear;
        this.carColor = carColor;
        this.carFuel = carFuel;
        this.priceDay = priceDay;
        this.comment = comment;
        this.periods = periods;
        this.orderList = orderList;
    }

    public Long getId() {   return id;    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(String carFuel) {
        this.carFuel = carFuel;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<RentalPeriod> getPeriods() {
        return periods;
    }

    public void setPeriods(List<RentalPeriod> periods) {
        this.periods = periods;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
