package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.AddressDao;
import com.github.shevstrukk.dao.impl.DefaultAddressDao;
import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.service.AddressService;

public class DefaultAddressService implements AddressService {
    private static class SingletonHolder {
        static final AddressService HOLDER_INSTANCE = new DefaultAddressService();
    }
    public static AddressService getInstance() {
        return DefaultAddressService.SingletonHolder.HOLDER_INSTANCE;
    }

    private AddressDao addressDao = DefaultAddressDao.getInstance();

    public  Address saveAddress(Address address){
     return    addressDao.saveAddress(address);
    }
}
