package com.github.Shevstrukk.service.address;
import com.github.Shevstrukk.dao.address.AddressDao;
import com.github.Shevstrukk.model.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultAddressServiceTest {
       @Mock
    AddressDao defaultAddressDao;
    @InjectMocks
    DefaultAddressService addressService;
    @Test
    public void saveAddress() {
        Address address = new Address(null, "sss", "sss", "ddd", 5, 5, null );
        when(defaultAddressDao.saveAddress(address)).thenReturn(new Address(null, "sss",
                "sss", "ddd", 5, 5, null ));
        Address address1 = addressService.saveAddress(address);
        assertEquals(address1.getCity(), address.getCity());
        assertEquals(address1.getHome(), address.getHome());
        assertEquals(address1.getState(), address.getState());
    }
}