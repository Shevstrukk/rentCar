package com.github.Shevstrukk.dao.address;

import com.github.Shevstrukk.dao.converter.AddressConverter;
import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class DefaultAddressDao implements AddressDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAddressDao.class);
    private final SessionFactory sessionFactory;
    @Autowired
    public DefaultAddressDao(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;    }

    public Address saveAddress( Address address){
        AddressEntity addressEntity = AddressConverter.toEntity(address);
       // Session session = EMUtil.getSession();
      // session.beginTransaction();
       final Session session = sessionFactory.getCurrentSession();
        session.save(addressEntity);
//        session.getTransaction().commit();
//        session.close();
        return AddressConverter.fromEntity(addressEntity);
    }

}
