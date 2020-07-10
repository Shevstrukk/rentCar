package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.AddressDao;
import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.converter.AddressConverter;
import com.github.shevstrukk.dao.entity.AddressEntity;
import com.github.shevstrukk.model.Address;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultAddressDao implements AddressDao {

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
