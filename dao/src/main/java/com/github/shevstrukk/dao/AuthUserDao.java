package com.github.shevstrukk.dao;

import com.github.shevstrukk.model.AuthUser;

public interface AuthUserDao {
    AuthUser getByLogin(String login);
   // void saveAuthUser (AuthUser user);
}
