package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.AuthUserDao;
import com.github.shevstrukk.dao.impl.DefaultAuthUserDao;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.service.SecurityService;

public class DefaultSecurityService implements SecurityService {
    private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();
    private static volatile SecurityService instance;

    public static SecurityService getInstance() {
        SecurityService local = instance;
        if (local == null) {
            synchronized (SecurityService.class) {
                local = instance;
                if (local == null) {
                    instance = local = new DefaultSecurityService();
                }
            }
        }
        return local;
    }

    @Override
    public AuthUser getByLogin(String login, String password) {
        AuthUser authUser = authUserDao.getByLogin(login);
        if(authUser==null){
            return null;
        }
        if (authUser.getPassword().equals(password)){
            return authUser;
        }
        return null;
    }


//    public void saveAuthUser(AuthUser user) {
//authUserDao.saveAuthUser(user);
//    }
}
