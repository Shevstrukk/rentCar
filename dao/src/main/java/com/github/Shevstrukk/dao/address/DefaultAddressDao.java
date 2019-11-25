package com.github.Shevstrukk.dao.address;

import com.github.Shevstrukk.dao.converter.AddressConverter;
import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.Address;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultAddressDao implements AddressDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAddressDao.class);
    public DefaultAddressDao() {    }

    private static class SingletonHolder {
        static final AddressDao HOLDER_INSTANCE = new DefaultAddressDao();
    }

    public static AddressDao getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

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
