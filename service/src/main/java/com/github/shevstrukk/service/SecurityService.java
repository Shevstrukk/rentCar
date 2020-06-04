package com.github.shevstrukk.service;

import com.github.shevstrukk.model.AuthUser;

public interface SecurityService {
    AuthUser getByLogin(String login, String password);
   // void saveAuthUser (AuthUser user);
}
