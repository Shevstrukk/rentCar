package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.AddressDao;
import com.github.shevstrukk.dao.AuthUserDao;
import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.UserDAO;
import com.github.shevstrukk.dao.entity.AuthUserEntity;
import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Role;
import com.github.shevstrukk.model.User;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DefaultAuthUserDaoTest {
    AuthUserDao authUserDao = new DefaultAuthUserDao();
    AddressDao addressDao=new DefaultAddressDao();
    UserDAO userDAO = new DefaultUserDao();

    @Test
    public void getByLogin() {
        final AuthUser user = authUserDao.getByLogin("pom");
        assertNull(user);
    }

    @Test
    public void saveAuthUser() {
        Address addressFromDB = addressDao.saveAddress( new Address(null, "Belarus", "Bobruisk", "Ulianova", 49, 5, null));
        User user = new User(null, "dimon", "dimon", "333", null, addressFromDB, null);
        User userDB = userDAO.save(user);
        AuthUser authUser = new AuthUser(null, "dimon", "dimon", Role.USER, userDB);
        Long id = authUserDao.saveAuthUser(authUser);
        AuthUserEntity fromDB = HibernateUtil.getSession().get(AuthUserEntity.class, id);
        assertNotNull(fromDB);
        assertEquals(authUser.getLogin(),fromDB.getLogin());
        assertEquals(authUser.getPassword(),fromDB.getPassword());

    }
}