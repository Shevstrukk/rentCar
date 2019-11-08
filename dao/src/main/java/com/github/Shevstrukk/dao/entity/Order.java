package com.github.Shevstrukk.dao.entity;

import javax.persistence.*;
import java.util.*;

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

    @ManyToMany(//cascade = CascadeType.ALL, изчезла ошибка different object with the same identifier value was already associated with the session
            fetch  = FetchType.EAGER) // опыт
             //fetch = FetchType.LAZY)
    @JoinTable(name = "orders_cars", joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "cars_id")}
    )
    private List<Car> cars = new ArrayList<>();
    public Order() {}

    public Order(Integer id, int rentDay, int price, Person person, List<Car> cars) {
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

    public List<Car> getCars() {        return cars;    }

    public void setCars(List<Car> cars) {        this.cars = cars;    }

    public  void addCar(Car car){
        cars.add(car);
        car.getOrders().add(this);
    }
    public void deleteCars(Car car){
        cars.remove(car);
        car.getOrders().remove(this);
    }

}
