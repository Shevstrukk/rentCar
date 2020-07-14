package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.UserDAO;
import com.github.shevstrukk.model.User;
import com.github.shevstrukk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DefaultUserService implements UserService {

    private final UserDAO userDAO;

    public DefaultUserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public User save(User user) {
        return userDAO.save( user);
    }
    public User saveOrUpdate(Long userId, Long orderId) {
        return userDAO.saveOrUpdate( userId, orderId);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }
}