package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultAuthUsersDAO;
import com.github.Shevstrukk.dao.AuthUsersDAO;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.model.AuthUser;


import java.util.List;

public class DefaultUserService implements UserService {
    DefaultAuthUsersDAO defaultAuthUsersDAO;

    public DefaultUserService(DefaultAuthUsersDAO defaultAuthUsersDAO) {
        this.defaultAuthUsersDAO = defaultAuthUsersDAO;
    }

    public AuthUser login(String login, String password) {
        List<AuthUser> userList = listAllUsers();
       // AuthUser user;
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
        AuthUser newAuthUser =   defaultAuthUsersDAO.saveOrUpdateAuthUser(new AuthUser(null,login,password,"user",null));
        return newAuthUser;

    }
    public List<AuthUser> listAllUsers () {
        return defaultAuthUsersDAO.listAllUsers();
    }

    public void deleteAuthUser (int id){
        defaultAuthUsersDAO.deleteAuthUser( id);
    }

    public AuthUser update(int id, int personId){ return defaultAuthUsersDAO.update(id, personId);}


}
