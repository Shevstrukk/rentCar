package com.github.Shevstrukk.dao.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AddressEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="state")
    private String state;

    @Column(name="city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name="home")
    private int home;

    @Column(name="number")
    private int number;

    @OneToOne(mappedBy = "addressEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private PersonEntity personAddress;
    public AddressEntity() {}

    public AddressEntity(Integer id, String state, String city, String street, int home, int number) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.home = home;
        this.number = number;
    }

    public AddressEntity(Integer id, String state, String city, String street, int home, int number, PersonEntity person) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.home = home;
        this.number = number;
        this.id=id;
        this.personAddress = person;
    }

    public Integer getId() {     return id;   }
    public void setId(Integer id) {    this.id = id;    }

    public String getState() {     return state;    }
    public void setState(String state) {    this.state = state;    }


    public String getCity() {     return city;   }
    public void setCity(String city) {    this.city = city; }

    public String getStreet() {    return street;   }
    public void setStreet(String street) {   this.street = street;    }


    public int getHome() {        return home;    }
    public void setHome(int home) {        this.home = home;    }


    public int getNumber() {        return number;    }
    public void setNumber(int number) {        this.number = number;    }

   // @OneToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "person_id")

    public PersonEntity getPerson() {        return personAddress;    }
    public void setPerson(PersonEntity person) {        this.personAddress = person;    }
}
