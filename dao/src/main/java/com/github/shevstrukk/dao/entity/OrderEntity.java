package com.github.shevstrukk.dao.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="rent_day")
    private int rentDay;
    @Column(name="price")
    private int priceSum;
    @Column(name="date_order")
    private java.time.LocalDateTime date;

    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }  ,   fetch  = FetchType.EAGER)
    @JoinTable (name="order_cars",
            joinColumns=@JoinColumn (name="order_id"),
            inverseJoinColumns=@JoinColumn(name="car_id"))
    private List<CarEntity> carEntityList;


    public OrderEntity () {}

    public OrderEntity(int rentDay, int priceSum, LocalDateTime date, List<CarEntity> carEntityList) {
        this.rentDay = rentDay;
        this.priceSum = priceSum;
        this.date = date;
        this.carEntityList = carEntityList;
    }

    public OrderEntity(Long id, int rentDay, int priceSum, LocalDateTime date,
                       UserEntity userEntity, List<CarEntity> carEntityList) {
        this.rentDay = rentDay;
        this.priceSum = priceSum;
        this.date = date;
        this.userEntity = userEntity;
        this.carEntityList = carEntityList;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<CarEntity> getCarEntityList() {
        return carEntityList;
    }

    public void setCarEntityList(List<CarEntity> carEntityList) {
        this.carEntityList = carEntityList;
    }

    public  void addCar(CarEntity carEntity){
        carEntityList.add(carEntity);
        carEntity.getOrderEntityList().add(this);
    }
    public void deleteCars(CarEntity carEntity){
        carEntityList.remove(carEntity);
        carEntity.getOrderEntityList().remove(this);
    }
}
