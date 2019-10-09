package com.github.Shevstrukk.service;

import com.github.Shevstrukk.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DefaultPersonServiceTest {

    @Test
    public void listAllPerson() {
        Person person = new Person("max", "maxov", 2);
        Person person1 = new Person("max1", "maxov1", 2);
        Person person2 = new Person("max2", "maxov2", 2);
        List<Person> expected=null;
        try {
             expected = DefaultPersonService.getInstance().listAllPerson();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Person> real = new ArrayList<>();
        real.add(person);
        real.add(person1);
        real.add(person2);
        Assert.assertEquals(expected, real);
    }
}
