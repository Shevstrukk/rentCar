package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.entity.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DefaultPersonEntityDAOTest {
//    PersonDAO personDAO = DefaultPersonDAO.getInstance();
//
//    @Test
//    public void insertPerson(){
//        AuthUserEntity authUserEntity = new AuthUserEntity(null, "vitalij", "1", "admin", null);
//        AddressEntity addressEntity = new AddressEntity(null, "California", "TTT", "54Sreet", 5, 6);
//        List<PhoneEntity> phoneEntityList = new ArrayList<>();
//        phoneEntityList.add(new PhoneEntity(null, "8888", null));
//        List<CarEntity> carEntityList = new ArrayList<>();
//        carEntityList.add(new CarEntity(null, "BMV", 2019, "Black", 25, "ok", null));
//        List<OrderEntity> orderEntityList = new ArrayList<>();
//        orderEntityList.add(new OrderEntity(null, 5, 20, null, carEntityList));
//        PersonEntity person = new PersonEntity(null,"Maks", "Ivanovich", authUserEntity, addressEntity, phoneEntityList, null);
//        PersonEntity insertPerson = personDAO.insertPerson(person);
//        assertEquals(person.getFirstName(), insertPerson.getFirstName());
//        assertEquals(person.getLastName(), insertPerson.getLastName());
//        assertEquals(person.getAuthUserEntity().getLogin(), insertPerson.getAuthUserEntity().getLogin());
//        assertEquals(person.getAuthUserEntity().getPassword(), insertPerson.getAuthUserEntity().getPassword());
//        assertEquals(person.getAddressEntity().getPerson(), insertPerson.getAddressEntity().getPerson());
//        assertNotNull(insertPerson.getId());
//    }
//    @Test
//    public void getPerson(){
//        AuthUserEntity authUserEntity = new AuthUserEntity(null, "vitalij", "1", "admin", null);
//        AddressEntity addressEntity = new AddressEntity(null, "California", "TTT", "54Sreet", 5, 6);
//        List<PhoneEntity> phoneEntityList = new ArrayList<>();
//        phoneEntityList.add(new PhoneEntity(null, "8888", null));
//        List<CarEntity> carEntityList = new ArrayList<>();
//        carEntityList.add(new CarEntity(null, "BMV", 2019, "Black", 25, "ok", null));
//        List<OrderEntity> orderEntityList = new ArrayList<>();
//        orderEntityList.add(new OrderEntity(null, 5, 20, null, carEntityList));
//
//        PersonEntity person = new PersonEntity(null,"Maks", "Ivanovich", authUserEntity, addressEntity, phoneEntityList, orderEntityList);
//        PersonEntity insertPerson = personDAO.insertPerson(person);
//        final Integer id = insertPerson.getId();
//        PersonEntity person1 = personDAO.getPerson(id);
//        assertNotNull(person1);
//        assertEquals(person.getFirstName(), insertPerson.getFirstName());
//        assertEquals(person.getLastName(), insertPerson.getLastName());
//        assertEquals(person.getAuthUserEntity().getLogin(), insertPerson.getAuthUserEntity().getLogin());
//        assertEquals(person.getAuthUserEntity().getPassword(), insertPerson.getAuthUserEntity().getPassword());
//        assertEquals(person.getAddressEntity().getPerson(), insertPerson.getAddressEntity().getPerson());
//        assertEquals(id, person1.getId());
    }
//    @Test
//    public void updatePerson(){
//        AuthUserEntity authUser = new AuthUserEntity(null, "vitalij", "1", "admin", null);
//        AddressEntity address = new AddressEntity(null, "California", "TTT", "54Sreet", 5, 6);
//        List<PhoneEntity> phoneList = new ArrayList<>();
//        phoneList.add(new PhoneEntity(null, "8888", null));
//        List<CarEntity> carList = new ArrayList<>();
//        carList.add(new CarEntity(null, "BMV", 2019, "Black", 25, "ok", null));
//        List<OrderEntity> orderList = new ArrayList<>();
//        orderList.add(new OrderEntity(null, 5, 20, null, carList));
//
//        PersonEntity person = new PersonEntity(null,"Maks", "Ivanovich", authUser, address, phoneList, orderList);
//        PersonEntity insertPerson = personDAO.insertPerson(person);
//        insertPerson.setFirstName("kolia");
//        insertPerson.setLastName("ttttt");
//        PersonEntity updatePerson = personDAO.updatePerson(insertPerson);
//        assertEquals(person.getFirstName(), updatePerson.getFirstName());
//        assertEquals(person.getLastName(), updatePerson.getLastName());
//
//
//    }
//}
