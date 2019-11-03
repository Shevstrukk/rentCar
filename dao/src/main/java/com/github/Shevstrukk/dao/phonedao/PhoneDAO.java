package com.github.Shevstrukk.dao.phonedao;

import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.entity.Phone;

import java.util.List;

public interface PhoneDAO {
    public List<Phone> savePhone(Phone phone, int id);
}
