package com.github.Shevstrukk.service;

import com.github.Shevstrukk.model.Person;


import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    public void insertPerson(Person person)throws SQLException;
    public List<Person> listAllPerson() throws SQLException;
    public void deletePerson(Person person) throws SQLException;
    public void updatePerson(Person person) throws SQLException;
    public Person getPerson(int id) throws SQLException;
}
