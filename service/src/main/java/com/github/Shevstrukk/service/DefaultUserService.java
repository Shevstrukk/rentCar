package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultUsersDAO;
import com.github.Shevstrukk.dao.UsersDAO;
import com.github.Shevstrukk.model.User;

import java.util.List;

public class DefaultUserService implements UserService {

    private UsersDAO userDAO = DefaultUsersDAO.getInstance();

    public DefaultUserService() {}

    public DefaultUserService(UsersDAO userDAO) {
        this.userDAO = userDAO;
    }

    private static class SingletonHolder {
        static final UserService HOLDER_INSTANCE = new DefaultUserService();
    }

    public static UserService getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public List<User> listAllUsers () {
        return userDAO.listAllUsers();
    }
    public User login(String login, String password) {
        User user = userDAO.getByLogin(login);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;

    }

}
