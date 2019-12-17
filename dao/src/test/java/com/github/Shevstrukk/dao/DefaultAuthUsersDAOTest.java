package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.config.DaoConfig;
import com.github.Shevstrukk.model.AuthUser;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class DefaultAuthUsersDAOTest {

    @Autowired
    AuthUsersDAO authUsersDao ;
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void getByLogin() {
    //   AuthUser authUser =authUsersDao.saveOrUpdateAuthUser(new AuthUser(null, "tyu", "poi", null, null));

    }
}