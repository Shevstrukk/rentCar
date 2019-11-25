package com.github.Shevstrukk.service.phoneservice;

import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.entity.PhoneEntity;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;

public interface PhoneService {
    public Person savePhone(Phone phoneEntity, int id);
    public Person deletePhone( int id);
}