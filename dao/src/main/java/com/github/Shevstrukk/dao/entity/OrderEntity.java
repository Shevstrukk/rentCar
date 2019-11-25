package com.github.Shevstrukk.dao.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "rent_day")
    private  int rentDay;

    @Column(name = "price")
    private  int price;

    @ManyToOne(cascade = { CascadeType.REMOVE})
    @JoinColumn(name = "person_id")
    private PersonEntity person1;

    @ManyToMany(//cascade = CascadeType.ALL, изчезла ошибка different object with the same identifier value was already associated with the session
            fetch  = FetchType.EAGER) // опыт
             //fetch = FetchType.LAZY)
    @JoinTable(name = "orders_cars", joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "cars_id")}
    )
    private List<CarEntity> carEntities = new ArrayList<>();
    public OrderEntity() {}

    public OrderEntity(Integer id, int rentDay, int price, PersonEntity person, List<CarEntity> carEntities) {
        this.id = id;
        this.rentDay = rentDay;
        this.price = price;
        this.person1 = person;
        this.carEntities = carEntities;
    }

    public Integer getId() {     return id;    }

    public void setId(Integer id) {        this.id = id;    }

    public int getRentDay() {        return rentDay;    }

    public void setRentDay(int rentDay) {        this.rentDay = rentDay;    }

    public int getPrice() {        return price;    }

    public void setPrice(int price) {        this.price = price;    }

    public PersonEntity getPerson() {        return person1;    }

    public void setPerson(PersonEntity person) {        this.person1 = person;    }

    public List<CarEntity> getCarEntities() {        return carEntities;    }

    public void setCarEntities(List<CarEntity> carEntities) {        this.carEntities = carEntities;    }

    public  void addCar(CarEntity carEntity){
        carEntities.add(carEntity);
        carEntity.getOrderEntities().add(this);
    }
    public void deleteCars(CarEntity carEntity){
        carEntities.remove(carEntity);
        carEntity.getOrderEntities().remove(this);
    }

}
