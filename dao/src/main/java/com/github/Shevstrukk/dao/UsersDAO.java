package com.github.Shevstrukk.dao;



import com.github.Shevstrukk.dao.entity.AuthUser;

import java.util.List;

public interface UsersDAO {
    public List<AuthUser> listAllUsers();
    public void saveOrUpdateAuthUser(AuthUser authUser);
    public void deleteAuthUser (int id);
  //  AuthUser getByLogin(String login);
}
