package com.github.Shevstrukk.service;


import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.model.AuthUser;

import java.util.List;

public interface UserService {
    // public List<AuthUser> listAllUsers();
    public AuthUser login(String login, String password);
    public AuthUser addAuthUser(String login, String password);
    public void deleteAuthUser (int id);
    public AuthUser update(int id, int personId);
}