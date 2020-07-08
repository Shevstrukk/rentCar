package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.entity.AuthUserEntity;
import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Role;
import com.github.shevstrukk.model.User;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DefaultAuthUserDaoTest {

    @Test
    public void getByLogin() {
        final AuthUser user = DefaultAuthUserDao.getInstance().getByLogin("pom");
        assertNull(user);
    }

    @Test
    public void saveAuthUser() {
        Address addressFromDB = DefaultAddressDao.getInstance().saveAddress( new Address(null, "Belarus", "Bobruisk", "Ulianova", 49, 5, null));
        User user = new User(null, "dimon", "dimon", "333", null, addressFromDB, null);
        User userDB = DefaultUserDao.getInstance().save(user);
        AuthUser authUser = new AuthUser(null, "dimon", "dimon", Role.USER, userDB);
        Long id = DefaultAuthUserDao.getInstance().saveAuthUser(authUser);
        AuthUserEntity fromDB = HibernateUtil.getSession().get(AuthUserEntity.class, id);
        assertNotNull(fromDB);
        assertEquals(authUser.getLogin(),fromDB.getLogin());
        assertEquals(authUser.getPassword(),fromDB.getPassword());

    }
}