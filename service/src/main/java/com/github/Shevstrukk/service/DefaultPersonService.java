package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.DefaultPersonDAO;
import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class DefaultPersonService implements PersonService {
    DefaultPersonDAO defaultPersonDAO;
@Autowired
    public DefaultPersonService(DefaultPersonDAO defaultPersonDAO) {
        this.defaultPersonDAO = defaultPersonDAO;
    }

    public List<AuthUserEntity> listAllAuthUser() {
        return defaultPersonDAO.listAllAuthUsers();
    }
    public List<Person> listAllPerson() {
        return defaultPersonDAO.listAllPerson();
    }

    public Person insertPerson(Person person)  {
        return defaultPersonDAO.insertPerson(person);
    }
    public Person updatePerson(Person person){
        return   defaultPersonDAO.updatePerson(person);
    }
    public Person updatePerson(Person person, Order orderEntity){
        return   defaultPersonDAO.updatePerson(person, orderEntity);
    }
    /* public void deletePerson(int person){
              DefaultPersonDAO.getInstance().deletePerson(person);
     }*/
    public Person getPerson(int id) {
        return defaultPersonDAO.getPerson(id);
    }
}
