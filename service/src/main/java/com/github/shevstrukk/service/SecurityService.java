package com.github.shevstrukk.service;
import com.github.shevstrukk.model.AuthUser;

public interface SecurityService {
    AuthUser getByLogin(String login, String password);
    Long saveAuthUser (AuthUser user);
    AuthUser isExist(String login);
}