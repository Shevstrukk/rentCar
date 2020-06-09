package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.AuthUserDao;
import com.github.shevstrukk.dao.impl.DefaultAuthUserDao;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.service.SecurityService;

public class DefaultSecurityService implements SecurityService {

    private static class SingletonHolder {
        static final SecurityService HOLDER_INSTANCE = new DefaultSecurityService();
    }
    public static SecurityService getInstance() {
        return DefaultSecurityService.SingletonHolder.HOLDER_INSTANCE;
    }

    private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();

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
