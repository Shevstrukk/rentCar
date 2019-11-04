package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultUsersDAO;
import com.github.Shevstrukk.dao.UsersDAO;
import com.github.Shevstrukk.dao.entity.AuthUser;


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


    public AuthUser login(String login, String password) {
        List<AuthUser> userList = listAllUsers();
        AuthUser user;
        if (userList == null) {
            return null;
        } else {
            for (AuthUser user1 : userList) {
                if (user1.getPassword().equals(password) & user1.getLogin().equals(login)) {
                    return user1;
                }
            }
        }
        return user = addAuthUser(login,password);
    }
    public AuthUser addAuthUser(String login, String password){
        AuthUser newAuthUser = new AuthUser(null,login,password,"user",null);
        userDAO.saveOrUpdateAuthUser(newAuthUser);
        return newAuthUser;

    }
    public List<AuthUser> listAllUsers () {
        return userDAO.listAllUsers();
    }

    public void deleteAuthUser (int id){
        userDAO.deleteAuthUser( id);
    }


}
