package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.UserDAO;
import com.github.shevstrukk.dao.converter.UserConverter;
import com.github.shevstrukk.dao.entity.OrderEntity;
import com.github.shevstrukk.dao.entity.UserEntity;
import com.github.shevstrukk.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultUserDao implements UserDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultUserDao.class);
    private static class SingletonHolder {
        static final UserDAO HOLDER_INSTANCE = new DefaultUserDao();
    }

    public static UserDAO getInstance() {
        return DefaultUserDao.SingletonHolder.HOLDER_INSTANCE;
    }


    @Override
    public List<User> getUsers() {
        final List<UserEntity> userEntity = HibernateUtil.getSession()
                .createQuery("from UserEntity").list();
             return userEntity.stream().map(UserConverter::fromEntity).collect(Collectors.toList());
    }

    @Override
    public User save(User user) {//не изменять админ регистрирует
        UserEntity userEntity = UserConverter.toEntity(user);
       final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(userEntity);
        session.getTransaction().commit();
        session.close();
        return UserConverter.fromEntity(userEntity);
    }
    public User saveOrUpdate(Long userId, Long orderId) {
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, userId);
        OrderEntity orderEntity = session.get(OrderEntity.class, orderId);
        userEntity.addOrder(orderEntity);
        session.saveOrUpdate(orderEntity);
        session.getTransaction().commit();
        session.close();
        return UserConverter.fromEntity(userEntity);
    }

    @Override
    public User getUserById(Long id) {
        UserEntity userEntity=null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        userEntity = session.get(UserEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return UserConverter.fromEntity(userEntity);
    }

}
