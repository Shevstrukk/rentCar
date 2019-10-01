package com.github.Shevstrukk.model;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private  int rentDay;

    public Person() {}

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String firstName, String lastName, int rentDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rentDay = rentDay;
    }

    public Person(String firstName, String lastName, int rentDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rentDay = rentDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getRentDay() {
        return rentDay;
    }

    public void setRentDay(int rentDay) {
        this.rentDay = rentDay;
    }
}
