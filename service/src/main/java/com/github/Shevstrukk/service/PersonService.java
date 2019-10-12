package com.github.Shevstrukk.service;

import com.github.Shevstrukk.model.Person;


import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    public void insertPerson(Person person);
    public List<Person> listAllPerson();
    public void deletePerson(Person person) ;
    public void updatePerson(Person person) ;
    public Person getPerson(int id) ;
}
