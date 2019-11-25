package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultPersonDAO;
import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Order;
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

    public List<AuthUserEntity> listAllAuthUser() {
        return personDAO.listAllAuthUsers();
    }
    public List<Person> listAllPerson() {
        return personDAO.listAllPerson();
    }

    public Person insertPerson(Person person)  {
        return personDAO.insertPerson(person);
    }
    public Person updatePerson(Person person){
        return   personDAO.updatePerson(person);
    }
    public Person updatePerson(Person person, Order orderEntity){
        return   personDAO.updatePerson(person, orderEntity);
    }
    /* public void deletePerson(int person){
              DefaultPersonDAO.getInstance().deletePerson(person);
     }*/
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }
}
