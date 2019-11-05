package com.github.Shevstrukk.dao.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "rent_day")
    private  int rentDay;

    @Column(name = "price")
    private  int price;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person1;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_cars", joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "cars_id")}
    )
    private Set<Car> cars= new HashSet<>();

    public Order() {}

    public Order(Integer id, int rentDay, int price, Person person, Set<Car> cars) {
        this.id = id;
        this.rentDay = rentDay;
        this.price = price;
        this.person1 = person;
        this.cars = cars;
    }

    public Integer getId() {     return id;    }

    public void setId(Integer id) {        this.id = id;    }

    public int getRentDay() {        return rentDay;    }

    public void setRentDay(int rentDay) {        this.rentDay = rentDay;    }

    public int getPrice() {        return price;    }

    public void setPrice(int price) {        this.price = price;    }

    public Person getPerson() {        return person1;    }

    public void setPerson(Person person) {        this.person1 = person;    }

    public Set<Car> getCars() {        return cars;    }

    public void setCars(Set<Car> cars) {        this.cars = cars;    }

    public  void addCar(Car car){
        cars.add(car);
        car.getOrders().add(this);
    }
    public void deleteCars(Car car){
        cars.remove(car);
        car.getOrders().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return rentDay == order.rentDay &&
                price == order.price &&
                id.equals(order.id) &&
                person1.equals(order.person1) &&
                cars.equals(order.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentDay, price, person1, cars);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", rentDay=" + rentDay +
                ", price=" + price +
                ", person=" + person1 +
                ", cars=" + cars +
                '}';
    }
}
