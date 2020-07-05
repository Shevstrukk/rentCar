package com.github.shevstrukk.model;

public class Address {
    private Long id;
    private String country;
    private String city;
    private String street;
    private Integer home;
    private Integer number;
    private User user;
    public Address() {}

    public Address(Long id, String country, String city, String street, Integer home, Integer number, User user) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.home = home;
        this.number = number;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
