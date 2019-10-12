package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.model.Person;

import java.util.List;


public interface PersonDAO {
    public Person insertPerson(Person person);
    public List<Person> listAllPerson();
    public boolean deletePerson(Person person) ;
    public boolean updatePerson(Person person) ;
    public Person getPerson(int id) ;
}
