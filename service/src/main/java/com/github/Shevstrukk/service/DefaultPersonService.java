package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultPersonDAO;
import com.github.Shevstrukk.model.Person;

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

    public List<Person> listAllPerson () {
        return DefaultPersonDAO.getInstance().listAllPerson();
    }

    public void insertPerson(Person person)  {
           DefaultPersonDAO.getInstance().insertPerson(person);
    }
    public void updatePerson(Person person){
        DefaultPersonDAO.getInstance().updatePerson(person);

    }
    public void deletePerson(int person){
             DefaultPersonDAO.getInstance().deletePerson(person);
    }
    public Person getPerson(int id) {
        return DefaultPersonDAO.getInstance().getPerson(id);
    }
}
