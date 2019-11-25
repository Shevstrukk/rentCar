package com.github.Shevstrukk.service.address;

import com.github.Shevstrukk.dao.address.AddressDao;
import com.github.Shevstrukk.dao.address.DefaultAddressDao;
import com.github.Shevstrukk.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultAddressService implements AdderessService{
    private static final Logger log = LoggerFactory.getLogger(DefaultAddressService.class);

    private AddressDao addressDao = DefaultAddressDao.getInstance();

    private AdderessService adderessService = DefaultAddressService.getInstance();

    public DefaultAddressService() {}

    private static class SingletonHolder {
        static final AdderessService HOLDER_INSTANCE = new DefaultAddressService();
    }

    public static AdderessService getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public Address saveAddress(Address address){ return  addressDao.saveAddress(address);}

}

