package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.model.Person;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DefaultPersonDAOTest {

    final PersonDAO personDAO = DefaultPersonDAO.getInstance();

    @Test
    public void insertPerson() {
        Person person = new Person("masha", "ffff", 5);
        Person insertPerson = personDAO.insertPerson(person);

        assertEquals(person.getFirstName(), insertPerson.getFirstName());
        assertEquals(person.getLastName(), insertPerson.getLastName());
        assertEquals(person.getRentDay(), insertPerson.getRentDay());
        assertNotNull(insertPerson.getId());
    }
}
