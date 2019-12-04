package com.github.Shevstrukk.service.address;

import com.github.Shevstrukk.dao.address.AddressDao;
import com.github.Shevstrukk.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class DefaultAddressService implements AddressService {
    private static final Logger log = LoggerFactory.getLogger(DefaultAddressService.class);
    @Autowired
    AddressDao defaultAddressDao;

    public DefaultAddressService(AddressDao address) { this.defaultAddressDao=address;}

    @Override
    @Transactional
    public Address saveAddress(Address address) {
        return  defaultAddressDao.saveAddress(address);
    }
}

