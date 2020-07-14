package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.AuthUserDao;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultSecurityService implements SecurityService {


    private AuthUserDao authUserDao;

    public DefaultSecurityService(AuthUserDao authUserDao) {
        this.authUserDao = authUserDao;
    }

    public AuthUser getByLogin(String login, String password) {
        AuthUser user = authUserDao.getByLogin(login);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    public AuthUser isExist(String login){
        AuthUser user = authUserDao.getByLogin(login);
        if(user == null){
            return null;
        }
        return user;
    }

    @Override
    public Long saveAuthUser(AuthUser user) {
        return authUserDao.saveAuthUser(user);
    }
}
