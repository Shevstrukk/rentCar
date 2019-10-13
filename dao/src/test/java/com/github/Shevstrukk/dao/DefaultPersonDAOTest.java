package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.model.Person;
import org.junit.Test;


import static org.junit.Assert.*;

public class DefaultPersonDAOTest {

    final PersonDAO personDAO = DefaultPersonDAO.getInstance();

    @Test
    public void insertPerson() {
        Person person = new Person(null,"masha", "ffff", 5);
        Person insertPerson = personDAO.insertPerson(person);

        assertEquals(person.getFirstName(), insertPerson.getFirstName());
        assertEquals(person.getLastName(), insertPerson.getLastName());
        assertEquals(person.getRentDay(), insertPerson.getRentDay());
        assertNotNull(insertPerson.getId());
    }

    @Test
    public void deletePerson() {
      final   Person person = new Person(null,"masha", "ffff", 5);
      final   Person savePerson = personDAO.insertPerson(person);
      final   Long id = savePerson.getId();
      Person person1 = personDAO.getPerson(id);
        System.out.println(id);
        assertNotNull(person1);
        final boolean deleted = personDAO.deletePerson(id);
        assertTrue(deleted);
        final Person afterDelete = personDAO.getPerson(id);
        assertNull(afterDelete);

    }

    @Test
    public void getPerson() {
        final Person person = new Person(null, "dddd", "hhhh", 6);
        final Person savePerson = personDAO.insertPerson(person);
        final Long id = savePerson.getId();
        final Person person1 = personDAO.getPerson(id);
        assertNotNull(person1);
        assertEquals(person.getFirstName(), person1.getFirstName());
        assertEquals(person.getLastName(), person1.getLastName());
        assertEquals(person.getRentDay(), person1.getRentDay());
        assertEquals(id, person1.getId());


    }

    @Test
    public void updatePerson() {
        final Person person = new Person(null, "TT", "SS", 8);
        final Person savePerson = personDAO.insertPerson(person);
        final Long id = savePerson.getId();
        final Person updatePerson = new Person(id, savePerson.getFirstName(), savePerson.getLastName(), 77);
        final boolean isUpdate = personDAO.updatePerson(updatePerson);
        assertTrue(isUpdate);
        final Person afterPerson = personDAO.getPerson(id);
        assertEquals(updatePerson.getFirstName(), afterPerson.getFirstName());
        assertEquals(updatePerson.getLastName(), afterPerson.getLastName());
        assertEquals(updatePerson.getRentDay(), afterPerson.getRentDay());

    }
}
