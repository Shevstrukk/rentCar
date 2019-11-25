package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultAuthUsersDAO;
import com.github.Shevstrukk.dao.AuthUsersDAO;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.model.AuthUser;


import java.util.List;

public class DefaultUserService implements UserService {

    private AuthUsersDAO userDAO = DefaultAuthUsersDAO.getInstance();

    public DefaultUserService() {}

    public DefaultUserService(AuthUsersDAO userDAO) {
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
            } return null;
        }
        //return user = addAuthUser(login,password);
    }
    public AuthUser addAuthUser(String login, String password){
        AuthUser newAuthUser =   userDAO.saveOrUpdateAuthUser(new AuthUser(null,login,password,"user",null));
        return newAuthUser;

    }
    public List<AuthUser> listAllUsers () {
        return userDAO.listAllUsers();
    }

    public void deleteAuthUser (int id){
        userDAO.deleteAuthUser( id);
    }

    public AuthUser update(int id, int personId){ return userDAO.update(id, personId);}


}
