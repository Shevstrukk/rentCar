package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultPersonDAO;
import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.model.Person;

import java.util.List;

public class DefaultPersonService implements PersonService {

    private PersonDAO personDAO = DefaultPersonDAO.getInstance();

    public DefaultPersonService() {}

    public DefaultPersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    private static class SingletonHolder {
        static final PersonService HOLDER_INSTANCE = new DefaultPersonService();
    }

    public static PersonService getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public List<Person> listAllPerson () {
        return personDAO.listAllPerson();
    }

    public Person insertPerson(Person person)  {
       return personDAO.insertPerson(person);
    }
    public void updatePerson(Person person){
        personDAO.updatePerson(person);

    }
    public void deletePerson(int person){
             DefaultPersonDAO.getInstance().deletePerson(person);
    }
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }
}
