package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultAuthUsersDAO;
import com.github.Shevstrukk.dao.AuthUsersDAO;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.model.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public class DefaultUserService implements UserService {

    @Autowired
    private final AuthUsersDAO authUsersDAO;
    public DefaultUserService(AuthUsersDAO authUsersDAO){
        this.authUsersDAO = authUsersDAO;
    }
    @Transactional
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
    @Transactional
    public AuthUser addAuthUser(String login, String password){
        AuthUser newAuthUser =   authUsersDAO.saveOrUpdateAuthUser(new AuthUser(null,login,password,"user",null));
        return newAuthUser;

    }
    @Transactional
    public List<AuthUser> listAllUsers () {
        return authUsersDAO.listAllUsers();
    }
    @Transactional
    public void deleteAuthUser (int id){
        authUsersDAO.deleteAuthUser( id);
    }
    @Transactional
    public AuthUser update(int id, int personId){ return authUsersDAO.update(id, personId);}


}
