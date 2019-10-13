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
      /*
       final SalaryDto salaryToSave = new SalaryDto(null, 30, "dev");
        final SalaryDto savedSalary = salaryDao.save(salaryToSave);
        final Long id = savedSalary.getId();
       final SalaryDto salaryDto = salaryDao.get(id);
        assertNotNull(salaryDto);
        final boolean deleted = salaryDao.delete(id);
        assertTrue(deleted);

        final SalaryDto afterDelete = salaryDao.get(id);
        assertNull(afterDelete);
*/
    }
}
