package com.github.Shevstrukk.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Integer id;
    private  int rentDay;
    private  int price;
    private Person person1;
    private List<Car> cars = new ArrayList<>();

    public Order(Integer id, int rentDay, int price, Person person1, List<Car> cars) {
        this.id = id;
        this.rentDay = rentDay;
        this.price = price;
        this.person1 = person1;
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public int getRentDay() {
        return rentDay;
    }

    public int getPrice() {
        return price;
    }

    public Person getPerson1() {
        return person1;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRentDay(int rentDay) {
        this.rentDay = rentDay;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
