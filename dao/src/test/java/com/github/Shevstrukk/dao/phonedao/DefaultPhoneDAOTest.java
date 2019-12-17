package com.github.Shevstrukk.dao.phonedao;

import com.github.Shevstrukk.dao.AuthUsersDAO;
import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.dao.address.AddressDao;
import com.github.Shevstrukk.dao.config.DaoConfig;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.entity.PhoneEntity;
import com.github.Shevstrukk.model.Address;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class DefaultPhoneDAOTest {
    @Autowired
    PersonDAO personDAO;
    @Autowired
    AuthUsersDAO authUsersDAO;
    @Autowired
    PhoneDAO phoneDAO;
    @Autowired
    AddressDao addressDao;

    @Test
    public void savePhone() {
//        AuthUser authUser = new AuthUser(null, "lll", "pp", null, null);
//        AuthUser authUser1 = authUsersDAO.saveAuthUserLogin(authUser);
//        List<Phone> phones = new ArrayList<>();
//        Address address = new Address(null, "sd", "sd", "ddf", 45, 55, null);
//        Address addressDB = addressDao.saveAddress(address);
//        Person person = new Person(null, "boria",
//                "shkliar", authUser1, addressDB, phones, null);
//        Person personDB = personDAO.insertPerson(person);
//        Phone phone = new Phone(null, "456", null);
//        Person person1= phoneDAO.savePhone(phone, personDB.getId());
//        assertNotNull(personDB);
//        assertNotNull(person1.getPhones());
    }

    @Test
    public void deletePhone() {
    }
}