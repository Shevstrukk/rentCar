package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.AddressDao;
import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DefaultAddressServiceTest {
    @Mock
    AddressDao defaultAddressDao;
    @InjectMocks
    DefaultAddressService addressService;
    @Test
    public void saveAddress() {
        Address address = new Address(1L, "sss", "sss", "ddd", 5, 5, null );
        when(defaultAddressDao.saveAddress(address)).thenReturn(address);
        Address address1 = addressService.saveAddress(address);
        assertEquals(address1.getCity(), "sss");
        assertEquals(address1.getHome(), address.getHome());
        assertEquals(address1.getCountry(), address.getCountry());
    }
}