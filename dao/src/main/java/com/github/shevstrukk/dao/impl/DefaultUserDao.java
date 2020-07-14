package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.UserDAO;
import com.github.shevstrukk.dao.converter.UserConverter;
import com.github.shevstrukk.dao.entity.OrderEntity;
import com.github.shevstrukk.dao.entity.UserEntity;
import com.github.shevstrukk.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class DefaultUserDao implements UserDAO {

    private static final Logger log = LoggerFactory.getLogger(DefaultUserDao.class);
    private final SessionFactory factory;

    public DefaultUserDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> getUsers() {
        final List<UserEntity> userEntity = factory.getCurrentSession().createQuery("from UserEntity ORDER BY id ASC").list();
        return userEntity.stream().
                map(UserConverter::fromEntity).collect(Collectors.toList());
    }

    @Override
    public User save(User user) {//не изменять админ регистрирует
        UserEntity userEntity = UserConverter.toEntity(user);
        final Session session = factory.getCurrentSession();
        session.saveOrUpdate(userEntity);
        return UserConverter.fromEntity(userEntity);
    }
    public User saveOrUpdate(Long userId, Long orderId) {
        final Session session = factory.getCurrentSession();
        UserEntity userEntity = session.get(UserEntity.class, userId);
        OrderEntity orderEntity = session.get(OrderEntity.class, orderId);
        userEntity.addOrder(orderEntity);
        session.saveOrUpdate(orderEntity);
        return UserConverter.fromEntity(userEntity);
    }

    @Override
    public User getUserById(Long id) {
        UserEntity userEntity=null;
        final Session session = factory.getCurrentSession();
        userEntity = session.get(UserEntity.class, id);
        return UserConverter.fromEntity(userEntity);
    }

}
