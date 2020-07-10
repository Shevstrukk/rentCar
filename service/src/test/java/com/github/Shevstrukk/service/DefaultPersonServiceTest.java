package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultPersonServiceTest {
    @InjectMocks
    DefaultPersonService service;
    @Mock
    PersonDAO personDAO;

    @Test
    public void insertPerson() {
        Person person = new Person(null, "ll", "sd", null,
                null, null, null);
        when(personDAO.insertPerson(person)).thenReturn(new Person(1, "ll", "sd", null,
                null, null, null));
        Person person1 =service.insertPerson(person);
        assertNotNull(person1);
        assertEquals(person.getFirstName(), person1.getFirstName());
    }

    @Test
    public void listAllPerson() {
//        List<Person> personList= new ArrayList<>();
//        Person person =new Person(null, "ll", "sd", null,
//                null, null, null);
//        personList.add(person);
//        when(personDAO.listAllPerson()).thenReturn(personList);
//        List<Person> personListDB = service.listAllPerson();
//        assertNotNull(personListDB);

    }
}