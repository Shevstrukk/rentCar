package com.github.Shevstrukk.model;

public class Phone {

    private Integer id;
    private String line;
    private Person person;

    public Phone(Integer id, String line, Person person) {
        this.id = id;
        this.line = line;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public String getLine() {
        return line;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
