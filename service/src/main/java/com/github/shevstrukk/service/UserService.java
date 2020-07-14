package com.github.shevstrukk.service;

import com.github.shevstrukk.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User save(User user);
    User saveOrUpdate(Long idUser, Long orderId);
    User getUserById(Long id);
}
