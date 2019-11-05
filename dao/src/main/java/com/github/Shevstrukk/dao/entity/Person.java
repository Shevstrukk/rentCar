package com.github.Shevstrukk.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name = "name")
    private  String firstName;

    @Column(name = "surname")
    private  String lastName;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private AuthUser authUser;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    @OneToMany(mappedBy = "person1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public Person() {}

    public Person(Integer id, String firstName, String lastName,
                  AuthUser authUser, Address address, List<Phone> phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authUser = authUser;
        this.address = address;
        this.phones=phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


       public AuthUser getAuthUser() {
        return authUser;
    }
    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }

    public Address getAddress() {   return address;    }
    public void setAddress(Address address) {     this.address = address;    }

    public List<Phone> getPhones() {        return phones;    }

    public void setPhones(List<Phone> phones) {        this.phones = phones;    }

    public void addPhones(Phone phone){
        phone.setPerson(this);
        phones.add(phone);
    }
}
