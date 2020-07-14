package com.github.shevstrukk.model;

public class AuthUser {
    private Long id;
    private String login;
    private String password;
    private Role role;
    private User user;

    public AuthUser() {}

    public AuthUser(Long id, String login, String password, Role role, User user) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}