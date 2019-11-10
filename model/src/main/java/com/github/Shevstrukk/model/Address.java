package com.github.Shevstrukk.model;

public class Address {

    private Integer id;
    private String state;
    private String city;
    private String street;
    private int home;
    private int number;
    private Person person;

    public Address(Integer id, String state,
                   String city, String street, int home, int number, Person person) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.street = street;
        this.home = home;
        this.number = number;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
