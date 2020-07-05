package com.github.shevstrukk.dao;

import com.github.shevstrukk.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    User save (User user);
    User saveOrUpdate (Long userId, Long orderId);
    User getUserById(Long id);
}
