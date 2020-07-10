package com.github.Shevstrukk.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private  Integer id;
    private  String firstName;
    private  String lastName;
    private AuthUser authUser;
    private Address address;
    private List<Phone> phones = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public Person(Integer id, String firstName, String lastName,
                  AuthUser authUser, Address address, List<Phone> phones, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authUser = authUser;
        this.address = address;
        this.phones = phones;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AuthUser getAuthUser() {
        return authUser;
    }

    public Address getAddress() {
        return address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
