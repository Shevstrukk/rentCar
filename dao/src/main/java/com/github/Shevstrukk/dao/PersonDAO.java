package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.model.Person;

import java.sql.SQLException;
import java.util.List;


public interface PersonDAO {
    public boolean insertPerson(Person person) throws SQLException;
    public List<Person> listAllPerson() throws SQLException;
    public boolean deletePerson(Person person) throws SQLException;
    public boolean updatePerson(Person person) throws SQLException;
    public Person getPerson(int id) throws SQLException;
}
