package com.github.shevstrukk.dao;

import com.github.shevstrukk.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    Long save (User user);
    User getUserById(Long id);
}
