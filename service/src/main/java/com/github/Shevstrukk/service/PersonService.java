package com.github.Shevstrukk.service;

import com.github.Shevstrukk.model.Person;


import java.util.List;

public interface PersonService {
    public Person insertPerson(Person person);
    public List<Person> listAllPerson();
    public void deletePerson(int person) ;
    public void updatePerson(Person person) ;
    public Person getPerson(int id) ;
}
