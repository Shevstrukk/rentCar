package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.AuthUserDao;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Role;

import java.util.HashMap;
import java.util.Map;

public class DefaultAuthUserDao implements AuthUserDao {
    Map<String, AuthUser> userGetLogin;
    private static volatile AuthUserDao instance;

    public DefaultAuthUserDao() {

        this.userGetLogin = new HashMap<>();
        userGetLogin.put("admin", new
                AuthUser("admin", "admin", Role.ADMIN, null));
        userGetLogin.put("user", new AuthUser("user", "user", Role.USER, null));
    }
    public static AuthUserDao getInstance() {
        AuthUserDao local = instance;
        if (local == null) {
            synchronized (AuthUserDao.class) {
                local = instance;
                if (local == null) {
                    instance = local = new DefaultAuthUserDao();
                }
            }
        }
        return local;
    }
    @Override
    public AuthUser getByLogin(String login) {
        return userGetLogin.get(login);
    }

//    public void saveAuthUser(AuthUser user) {
//        userGetLogin.putIfAbsent(user.getLogin(), user);
//    }
}
