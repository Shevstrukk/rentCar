package com.github.Shevstrukk.service;


import com.github.Shevstrukk.dao.entity.User;

import java.util.List;

public interface UserService {
    public List<User> listAllUsers();
     public User login(String login, String password);
}
