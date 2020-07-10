package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.AddressDao;
import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultAddressService implements AddressService {

    @Autowired
    private AddressDao addressDao;

    public  Address saveAddress(Address address){
     return    addressDao.saveAddress(address);
    }
}
