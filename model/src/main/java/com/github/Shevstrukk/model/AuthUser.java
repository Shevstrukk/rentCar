package com.github.Shevstrukk.model;

public class AuthUser {

    private Integer id;
    private String login;
    private String password;
    private String role;
    private Person person;

    public AuthUser(Integer id, String login, String password, String role, Person person) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
