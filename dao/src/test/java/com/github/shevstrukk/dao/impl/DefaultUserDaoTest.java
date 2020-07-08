package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.model.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultUserDaoTest {



    @Test
    public void save() {
        Address addressFromDB = DefaultAddressDao.getInstance().saveAddress( new Address(null, "Belarus", "Bobruisk", "Ulianova", 49, 5, null));
        User user = new User(null, "dimon", "dimon", "333", null, addressFromDB, null);
        User userDB = DefaultUserDao.getInstance().save(user);
        assertNotNull(userDB);
        assertEquals(userDB.getFirstName(), "dimon");
        assertEquals(userDB.getLastName(), "dimon");

    }


}