package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.AddressDao;
import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class DefaultAddressService implements AddressService {


    private final  AddressDao addressDao;
    @Autowired
    public DefaultAddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
    @Transactional
    public  Address saveAddress(Address address){
        return    addressDao.saveAddress(address);
    }
}
