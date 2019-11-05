package com.github.Shevstrukk.dao.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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

    @ManyToMany(mappedBy = "cars", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    public Car() {    }

    public Car(Integer id, String carName, int carYear,
               String carColor, int priceDay, String comment) {
        this.id = id;
        this.carName = carName;
        this.carYear = carYear;
        this.carColor = carColor;
        this.priceDay = priceDay;
        this.comment = comment;
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

    public Set<Order> getOrders() {     return orders;    }

    public void setOrders(Set<Order> orders) {        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carYear == car.carYear &&
                priceDay == car.priceDay &&
                id.equals(car.id) &&
                carName.equals(car.carName) &&
                carColor.equals(car.carColor) &&
                Objects.equals(comment, car.comment) &&
                orders.equals(car.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carName, carYear, carColor, priceDay, comment, orders);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carYear=" + carYear +
                ", carColor='" + carColor + '\'' +
                ", priceDay=" + priceDay +
                ", comment='" + comment + '\'' +
                ", orders=" + orders +
                '}';
    }
}
