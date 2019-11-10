package com.github.Shevstrukk.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class AuthUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="person_id")
    private PersonEntity person;


    public AuthUserEntity() {
    }

    public AuthUserEntity(Integer id, String login, String password, String role, PersonEntity person) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.person = person;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PersonEntity getPerson() {        return person;    }

    public void setPerson(PersonEntity person) {        this.person = person;    }
}

