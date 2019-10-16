package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultPersonDAO;
import com.github.Shevstrukk.model.Person;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class DefaultPersonServiceTest {
    DefaultPersonDAO dao = Mockito.mock(DefaultPersonDAO.class);
    PersonService service = new DefaultPersonService(dao);
    @Test
    public void getPerson() {
        final Person person = new Person((long) 2, "dddd", "hhhh", 6);
        Mockito.when(dao.getPerson(123)).thenReturn(person);

        Person personFromService = service.getPerson(123);

        assertNotNull(personFromService);
    }

    @Test
    public void listAllPerson() {
        List<Person> personMock = new ArrayList<>();
        final Person person = new Person((long) 2, "dddd", "hhhh", 6);
        final Person person1 = new Person((long) 1, "dddd", "hhhh", 6);
        personMock.add(person);
        personMock.add(person1);
        Mockito.when(dao.listAllPerson()).thenReturn(personMock);

    }
}
