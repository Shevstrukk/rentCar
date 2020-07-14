package com.github.Shevstrukk.service.phoneservice;

import com.github.Shevstrukk.dao.phonedao.PhoneDAO;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultPhoneServiceTest {
    @InjectMocks
    DefaultPhoneService service;
    @Mock
    PhoneDAO phoneDAO;

    @Test
    public void savePhone() {
        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone(null, "45454", null);
        phones.add(phone);
        when(phoneDAO.savePhone(phone, 3)).thenReturn(new Person(null, "sd",
                "sd", null, null, phones, null));
        Person person = service.savePhone(phone, 3);
        assertNotNull(person);
    }
}