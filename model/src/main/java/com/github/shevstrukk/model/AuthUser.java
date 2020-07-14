package com.github.shevstrukk.model.AuthUser;
import package com.github.shevstrukk.model.User user


public class AuthUser {
    private Long id;
    private String login;
    private String password;
    private com.github.shevstrukk.model.Role role;
    private com.github.shevstrukk.model.User user;

    public AuthUser() {}

    public AuthUser(Long id, String login, String password, com.github.shevstrukk.model.Role role, com.github.shevstrukk.model.User user) {

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

    public String getPassword() {
        return password;
    }

    public com.github.shevstrukk.model.Role getRole() {
        return role;
    }


    public void setRole(com.github.shevstrukk.model.Role role) {
        this.role = role;
    }

    public com.github.shevstrukk.model.User getUser() {
        return user;
    }

    public void setUser(com.github.shevstrukk.model.User user) {
        this.user = user;

    }
}
