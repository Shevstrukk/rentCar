package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.model.User;

import java.util.List;

public interface UsersDAO {
    public List<User> listAllUsers();
    User getByLogin(String login);
}
