package com.github.Shevstrukk.service.address;

import com.github.Shevstrukk.dao.address.AddressDao;
import com.github.Shevstrukk.dao.address.DefaultAddressDao;
import com.github.Shevstrukk.dao.base.BaseDao;
import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DefaultAddressService implements AdderessService{
    private static final Logger log = LoggerFactory.getLogger(DefaultAddressService.class);
    @Autowired
    AddressDao defaultAddressDao;

    public Address saveAddress(Address address){ return  defaultAddressDao.saveAddress(address);}

}

