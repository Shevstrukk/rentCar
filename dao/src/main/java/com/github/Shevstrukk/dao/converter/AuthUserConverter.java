package com.github.Shevstrukk.dao.converter;

import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.model.AuthUser;

import java.util.ArrayList;
import java.util.List;

public class AuthUserConverter {
    public static AuthUserEntity toEntity(AuthUser authUser){
        if(authUser==null){
            return null;
        }
        final AuthUserEntity authUserEntity = new AuthUserEntity();
        if (authUser.getId()!= null){
            authUserEntity.setId(authUser.getId());
        }
        authUserEntity.setLogin(authUser.getLogin());
        authUserEntity.setPassword(authUser.getPassword());
        authUserEntity.setRole(authUser.getRole());
        // authUserEntity.setPerson(PersonConverter.toEntity(authUser.getPerson()));
        return authUserEntity;
    }
    public static AuthUserEntity toEntityLogin(AuthUser authUser){
        if(authUser==null){
            return null;
        }
        final AuthUserEntity authUserEntity = new AuthUserEntity();
        // authUserEntity.setId(authUser.getId());
        authUserEntity.setLogin(authUser.getLogin());
        authUserEntity.setPassword(authUser.getPassword());
        authUserEntity.setRole(authUser.getRole());
        authUserEntity.setPerson(null);
        return authUserEntity;
    }
    public static AuthUser fromEntity(AuthUserEntity authUserEntity){
        if (authUserEntity == null){
            return  null;
        }
        return  new AuthUser(
                authUserEntity.getId(),
                authUserEntity.getLogin(),
                authUserEntity.getPassword(),
                authUserEntity.getRole(),
                null//PersonConverter.fromEntity(authUserEntity.getPerson())
        );
    }
    public static AuthUser fromEntityList(AuthUserEntity authUserEntity){
        if (authUserEntity == null){
            return  null;
        }
        return  new AuthUser(
                authUserEntity.getId(),
                authUserEntity.getLogin(),
                authUserEntity.getPassword(),
                authUserEntity.getRole(),
                PersonConverter.fromEntityList(authUserEntity.getPerson())
        );
    }
    public static List<AuthUser> fromListAuthUserEntity(List<AuthUserEntity> list){
        List<AuthUser> authUserList = new ArrayList<>();
        for(AuthUserEntity elem: list){
            authUserList.add(AuthUserConverter.fromEntityList(elem));
        }
        return authUserList;
    }

    public static AuthUser fromEntityAuth(AuthUserEntity authUserEntity){
        if (authUserEntity == null){
            return  null;
        }
        return  new AuthUser(
                authUserEntity.getId(),
                authUserEntity.getLogin(),
                authUserEntity.getPassword(),
                authUserEntity.getRole(),
                PersonConverter.fromEntityAuth(authUserEntity.getPerson())
        );
    }
}
