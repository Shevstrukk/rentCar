package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.entity.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DefaultPersonDAOTest {
    PersonDAO personDAO = DefaultPersonDAO.getInstance();

    @Test
    public void insertPerson(){
        AuthUser authUser = new AuthUser(null, "vitalij", "1", "admin", null);
        Address address = new Address(null, "California", "TTT", "54Sreet", 5, 6);
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone(null, "8888", null));
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(null, "BMV", 2019, "Black", 25, "ok", null));
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(null, 5, 20, null, carList));
        Person person = new Person(null,"Maks", "Ivanovich", authUser, address, phoneList, null);
        Person insertPerson = personDAO.insertPerson(person);
        assertEquals(person.getFirstName(), insertPerson.getFirstName());
        assertEquals(person.getLastName(), insertPerson.getLastName());
        assertEquals(person.getAuthUser().getLogin(), insertPerson.getAuthUser().getLogin());
        assertEquals(person.getAuthUser().getPassword(), insertPerson.getAuthUser().getPassword());
        assertEquals(person.getAddress().getPerson(), insertPerson.getAddress().getPerson());
        assertNotNull(insertPerson.getId());
    }
    @Test
    public void getPerson(){
        AuthUser authUser = new AuthUser(null, "vitalij", "1", "admin", null);
        Address address = new Address(null, "California", "TTT", "54Sreet", 5, 6);
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone(null, "8888", null));
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(null, "BMV", 2019, "Black", 25, "ok", null));
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(null, 5, 20, null, carList));

        Person person = new Person(null,"Maks", "Ivanovich", authUser, address, phoneList, orderList);
        Person insertPerson = personDAO.insertPerson(person);
        final Integer id = insertPerson.getId();
        Person person1 = personDAO.getPerson(id);
        assertNotNull(person1);
        assertEquals(person.getFirstName(), insertPerson.getFirstName());
        assertEquals(person.getLastName(), insertPerson.getLastName());
        assertEquals(person.getAuthUser().getLogin(), insertPerson.getAuthUser().getLogin());
        assertEquals(person.getAuthUser().getPassword(), insertPerson.getAuthUser().getPassword());
        assertEquals(person.getAddress().getPerson(), insertPerson.getAddress().getPerson());
        assertEquals(id, person1.getId());
        }
}
