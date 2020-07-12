package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.AuthUserDao;

import com.github.shevstrukk.dao.converter.AuthUserConverter;
import com.github.shevstrukk.dao.entity.AuthUserEntity;
import com.github.shevstrukk.model.AuthUser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;



public class DefaultAuthUserDao implements AuthUserDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAuthUserDao.class);
    private final SessionFactory factory;

    public DefaultAuthUserDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public AuthUser getByLogin(String login) {
        AuthUserEntity authUserEntity;
        try {authUserEntity = (AuthUserEntity)factory.getCurrentSession().createQuery("from AuthUserEntity ua where ua.login = :login")
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
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(authUserEntity);
        return authUserEntity.getId();
    }
}
