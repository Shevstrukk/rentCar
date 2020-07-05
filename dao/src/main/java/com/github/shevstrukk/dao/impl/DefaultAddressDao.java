package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.AddressDao;
import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.converter.AddressConverter;
import com.github.shevstrukk.dao.entity.AddressEntity;
import com.github.shevstrukk.model.Address;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultAddressDao implements AddressDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAddressDao.class);
    private static class SingletonHolder {
        static final AddressDao HOLDER_INSTANCE = new DefaultAddressDao();
    }
    public static AddressDao getInstance() {
        return DefaultAddressDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public Address saveAddress(Address address) {
        AddressEntity addressEntity = AddressConverter.toEntity(address);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(addressEntity);
        session.getTransaction().commit();
        session.close();
        return AddressConverter.fromEntity(addressEntity);
    }
}
