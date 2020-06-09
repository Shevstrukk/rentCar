package com.github.shevstrukk.service;

import com.github.shevstrukk.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    Long save(User user);
    User getUserById(Long id);
}
