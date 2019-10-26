package com.github.Shevstrukk.service;


import com.github.Shevstrukk.dao.entity.AuthUser;

import java.util.List;

public interface UserService {
    public List<AuthUser> listAllUsers();
     public AuthUser login(String login, String password);
    public AuthUser addAuthUser(String login, String password);
}
