package com.github.shevstrukk.service;

import com.github.shevstrukk.model.Address;

public interface AddressService {
    Address saveAddress(Address address);
    Address updateAddress(Address address);
}
