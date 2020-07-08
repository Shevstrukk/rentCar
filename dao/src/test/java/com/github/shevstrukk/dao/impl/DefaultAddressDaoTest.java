package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.entity.UserEntity;
import com.github.shevstrukk.model.Address;
import org.junit.Test;
import static org.junit.Assert.*;



public class DefaultAddressDaoTest {

    @Test
    public void saveAddress() {
        UserEntity userEntity = new UserEntity(null, "misha", "ivanov", "55555", null, null, null);
        Address addressFromDB = DefaultAddressDao.getInstance().saveAddress( new Address(null, "Belarus", "Bobruisk", "Ulianova", 49, 5, null));
        assertEquals(addressFromDB.getCountry(), "Belarus");
        assertEquals(addressFromDB.getCity(), "Bobruisk");
    }
}