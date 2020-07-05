package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.AuthUserDao;
import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.converter.AuthUserConverter;
import com.github.shevstrukk.dao.entity.AuthUserEntity;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.sql.*;


public class DefaultAuthUserDao implements AuthUserDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAuthUserDao.class);

    private static class SingletonHolder {
        static final AuthUserDao HOLDER_INSTANCE = new DefaultAuthUserDao();
    }

    public static AuthUserDao getInstance() {
        return DefaultAuthUserDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public AuthUser getByLogin(String login) {
        AuthUserEntity authUserEntity;
        try {authUserEntity = (AuthUserEntity)HibernateUtil.getSession().createQuery("from AuthUserEntity ua where ua.login = :login")
                .setParameter("login", login)
                .getSingleResult();

        } catch ( NoResultException e) {
        log.info("user not found by login{}", login);
        authUserEntity = null;
        }
        return AuthUserConverter.fromEntityAuth(authUserEntity);
    }

    @Override
    public Long saveAuthUser(AuthUser user) {
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(user);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(authUserEntity);
        session.getTransaction().commit();
        session.close();
        return authUserEntity.getId();
    }
}
