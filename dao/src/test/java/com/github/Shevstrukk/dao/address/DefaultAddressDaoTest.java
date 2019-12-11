package com.github.Shevstrukk.dao.address;

import com.github.Shevstrukk.dao.config.DaoConfig;
import com.github.Shevstrukk.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class DefaultAddressDaoTest {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
   AddressDao addressDao;

    @Test
    public void saveAddress() {
        Address address =
                new Address(null, "mogilev", "bobr", "50let", 45, 25, null);
       Address newAddress = addressDao.saveAddress(address);
        sessionFactory.getCurrentSession().flush();
       assertNotNull(newAddress);
    }
}