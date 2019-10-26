package com.github.Shevstrukk.dao;



import com.github.Shevstrukk.dao.entity.AuthUser;

import java.util.List;

public interface UsersDAO {
    public List<AuthUser> listAllUsers();
  //  AuthUser getByLogin(String login);
}
