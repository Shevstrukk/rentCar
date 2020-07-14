package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.config.DaoConfig;
import com.github.Shevstrukk.dao.converter.AuthUserConverter;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.model.Address;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import org.hibernate.SessionFactory;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class DefaultAuthUsersDAOTest {

    @Autowired
    AuthUsersDAO authUsersDao ;
    @Autowired
    PersonDAO personDAO;
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void getByLogin() {
        final  AuthUser authUser = authUsersDao.saveOrUpdateAuthUser(new AuthUser(null, "tyu", "poi", "user", null));
        final AuthUser authUserDB= authUsersDao.getByLogin("tyu");
        assertNotNull(authUser);
        assertEquals(authUser.getLogin(), authUserDB.getLogin());
    }

   @Test
    public void saveOrUpdateAuthUser() {
       final  AuthUser authUser = authUsersDao.saveOrUpdateAuthUser(new AuthUser(null, "tyu",
               "poi", "user", null));
       AuthUser authUserDB = AuthUserConverter.fromEntity(
               sessionFactory.getCurrentSession().get(AuthUserEntity.class, authUser.getId()));
       assertNotNull(authUser);
       assertNotNull(authUserDB);
       assertEquals(authUser.getId(),authUserDB.getId());
       assertEquals(authUser.getLogin(), authUserDB.getLogin());
       assertEquals(authUser.getPassword(), authUserDB.getPassword());
    }

    @Test
    public void update() {
//        final  AuthUser authUser = authUsersDao.saveOrUpdateAuthUser(new AuthUser(null, "tyu",
//                "poi", "user", null));
//        Address address = new Address(null, "ds", "sds", "ss", 55, 45, null);
//        final Person person = new Person(null, "ass", "ass", authUser, address, null, null ) ;
//        Person personDB = personDAO.insertPerson(person);
//        sessionFactory.getCurrentSession().flush();
//        sessionFactory.getCurrentSession().clear();
//        AuthUser authUserUpdate = authUsersDao.update(authUser.getId(), personDB.getId());
    }

    @Test
    public void deleteAuthUser() {
        AuthUser authUser = authUsersDao.saveOrUpdateAuthUser(new AuthUser(null, "root",
                "root", "user", null));
        authUsersDao.deleteAuthUser(authUser.getId());
        AuthUser authUserDelte = authUsersDao.getByLogin("root");
        assertNotNull(authUser);
        assertNull(authUserDelte);
    }
}