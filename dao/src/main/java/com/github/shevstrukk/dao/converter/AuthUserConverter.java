package com.github.shevstrukk.dao.converter;

import com.github.shevstrukk.dao.entity.AuthUserEntity;
import com.github.shevstrukk.model.AuthUser;

public class AuthUserConverter {

    public static AuthUserEntity toEntity(AuthUser authUser) {
        if (authUser == null) {
            return null;
        } else {
            final AuthUserEntity authUserEntity = new AuthUserEntity();
            authUserEntity.setLogin(authUser.getLogin());
            authUserEntity.setPassword(authUser.getPassword());
            authUserEntity.setRole(authUser.getRole());
            authUserEntity.setUserEntity(UserConverter.toEntity(authUser.getUser()));
            return authUserEntity;
        }
    }

    public static AuthUser fromEntityAuth(AuthUserEntity authUserEntity) {
        if (authUserEntity == null) {
            return null;
        }
            return new AuthUser(authUserEntity.getId(),
                    authUserEntity.getLogin(),
                    authUserEntity.getPassword(),
                    authUserEntity.getRole(),
                    UserConverter.fromAuthUserEntity(authUserEntity.getUserEntity())
             );


    }

}