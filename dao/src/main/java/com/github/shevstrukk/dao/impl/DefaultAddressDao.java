package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.AddressDao;

import com.github.shevstrukk.dao.converter.AddressConverter;
import com.github.shevstrukk.dao.entity.AddressEntity;
import com.github.shevstrukk.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class DefaultAddressDao implements AddressDao {
    private final SessionFactory factory;

    public DefaultAddressDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Address saveAddress(Address address) {
        AddressEntity addressEntity = AddressConverter.toEntity(address);
       final Session session = factory.getCurrentSession();
        session.save(addressEntity);
        return AddressConverter.fromEntity(addressEntity);
    }
    @Override
    public Address updateAddress(Address address) {
       // AddressEntity addressEntity = AddressConverter.toEntity(address);
        final Session session = factory.getCurrentSession();
        AddressEntity addressEntity = session.get(AddressEntity.class, address.getId());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setCity(address.getCity());
        addressEntity.setStreet(address.getStreet());
        addressEntity.setHome(address.getHome());
        addressEntity.setNumber(address.getNumber());
        session.saveOrUpdate(addressEntity);
        return AddressConverter.fromEntity(addressEntity);
    }
}
