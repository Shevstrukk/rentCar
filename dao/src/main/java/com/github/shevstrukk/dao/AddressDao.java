package com.github.shevstrukk.dao;

import com.github.shevstrukk.model.Address;

public interface AddressDao {
    Address saveAddress(Address address);
    Address updateAddress(Address address);
}
