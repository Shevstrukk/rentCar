package com.github.Shevstrukk.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "line")
    private String line;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private Person person;

    public Phone() {}

    public Phone(Integer id, String line, Person person) {
        this.id=id;
        this.line = line;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
