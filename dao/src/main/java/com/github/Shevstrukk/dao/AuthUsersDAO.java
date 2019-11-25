package com.github.Shevstrukk.dao;



import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.model.AuthUser;

import java.util.List;

public interface AuthUsersDAO {
    public AuthUser saveAuthUserLogin(AuthUser authUser);
    public List<AuthUser> listAllUsers();
    public AuthUser saveOrUpdateAuthUser(AuthUser authUserEntity);
    public void deleteAuthUser (int id);
    public AuthUser update(int id, int personId);
    //  AuthUserEntity getByLogin(String login);
}
