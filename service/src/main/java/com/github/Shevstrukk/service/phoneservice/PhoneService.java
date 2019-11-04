package com.github.Shevstrukk.service.phoneservice;

import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.entity.Phone;

import java.util.List;

public interface PhoneService {
    public Person savePhone(Phone phone, int id);
    public Person deletePhone(int personId, int id);
}
