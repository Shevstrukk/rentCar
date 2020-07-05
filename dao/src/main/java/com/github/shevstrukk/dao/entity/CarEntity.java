package com.github.shevstrukk.dao.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="car_model")
    private String carModel;

    @Column(name="car_name")
    private String carName;

    @Column(name="car_year")
    private int carYear;

    @Column(name="car_color")
    private String carColor;
    @Column(name="car_fuel")
    private String carFuel;
    @Column(name="price_day")
    private int priceDay;
    @Column(name="comment")
    private String comment;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<RentalPeriodEntity> periods;

    @ManyToMany(mappedBy = "carEntityList")
//    @JoinTable (name="order_cars",
//            joinColumns=@JoinColumn (name="car_id"),
//            inverseJoinColumns=@JoinColumn(name="order_id"))
    private List<OrderEntity> orderEntityList;

    public CarEntity() {    }

    public CarEntity(Long id, String carModel, String carName, int carYear,
                     String carColor, String carFuel, int priceDay,
                     String comment, List<RentalPeriodEntity> periods) {
        this.id = id;
        this.carModel = carModel;
        this.carName = carName;
        this.carYear = carYear;
        this.carColor = carColor;
        this.carFuel = carFuel;
        this.priceDay = priceDay;
        this.comment = comment;
        this.periods = periods;
    }

    public Long getId() {
        return id;
    }

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

    public List<RentalPeriodEntity> getPeriods() {
        return periods;
    }

    public void setPeriods(List<RentalPeriodEntity> periods) {
        this.periods = periods;
    }

    public void addRentalPeriod(RentalPeriodEntity periodEntity){
        periodEntity.setCar(this);
        periods.add(periodEntity);
    }
    public void removeRentalPeriod(RentalPeriodEntity periodEntity){
        periodEntity.setCar(null);
        periods.remove(periodEntity);
    }

    public List<OrderEntity> getOrderEntityList() {
        return orderEntityList;
    }

    public void setOrderEntityList(List<OrderEntity> orderEntityList) {
        this.orderEntityList = orderEntityList;
    }

}
