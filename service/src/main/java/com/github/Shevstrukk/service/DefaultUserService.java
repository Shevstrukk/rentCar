package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultUsersDAO;
import com.github.Shevstrukk.dao.UsersDAO;
import com.github.Shevstrukk.dao.entity.User;


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


    public User login(String login, String password) {
        List<User> userList= listAllUsers();
      //  User user = userDAO.getByLogin(login);
        if (userList == null) {
            return null;
        }else {
            for (User user1: userList){
                if (user1.getPassword().equals(password)&user1.getLogin().equals(login)) {
                    return user1;
                }
            }
        }return null;
    }
    public List<User> listAllUsers () {
        return userDAO.listAllUsers();
    }

}
