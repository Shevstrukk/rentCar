package com.github.Shevstrukk.dao.address;

import com.github.Shevstrukk.dao.converter.AddressConverter;
import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.Address;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultAddressDao implements AddressDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAddressDao.class);
    public DefaultAddressDao() {    }

    public Address saveAddress( Address address){
        AddressEntity addressEntity = AddressConverter.toEntity(address);
        Session session = EMUtil.getSession();
        session.beginTransaction();
        session.save(addressEntity);
        session.getTransaction().commit();
        session.close();
        return AddressConverter.fromEntity(addressEntity);
    }

}
