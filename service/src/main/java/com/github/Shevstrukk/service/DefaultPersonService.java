package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultPersonDAO;
import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DefaultPersonService implements PersonService {
    private DefaultPersonDAO instance;

    public DefaultPersonService() {}

    private static class SingletonHolder {
        static final PersonService HOLDER_INSTANCE = new DefaultPersonService();
    }

    public static PersonService getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public List<Person> listAllPerson () throws SQLException {
        return DefaultPersonDAO.getInstance().listAllPerson();
    }

    public void insertPerson(Person person) throws SQLException {
           DefaultPersonDAO.getInstance().insertPerson(person);
    }
    public void updatePerson(Person person)throws SQLException{
        DefaultPersonDAO.getInstance().updatePerson(person);

    }
    public void deletePerson(Person person)throws SQLException{
             DefaultPersonDAO.getInstance().deletePerson(person);
    }
    public Person getPerson(int id) throws SQLException{
        return DefaultPersonDAO.getInstance().getPerson(id);
    }
}
