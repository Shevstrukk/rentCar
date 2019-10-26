package com.github.Shevstrukk.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    private  Integer id;
    private  String firstName;
    private  String lastName;
    private AuthUser authUser;

    public Person() {}

    public Person(Integer id, String firstName, String lastName, AuthUser authUser) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authUser = authUser;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "surname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToOne(mappedBy = "person")
   // @JoinColumn(name = "person_id")
    public AuthUser getAuthUser() {
        return authUser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }
}
