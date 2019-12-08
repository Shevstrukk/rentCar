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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public class DefaultPersonService implements PersonService {

    private final PersonDAO dao;
    @Autowired
    public DefaultPersonService(PersonDAO personDAO){this.dao = personDAO;}

    @Transactional
    public List<AuthUserEntity> listAllAuthUser() {
        return dao.listAllAuthUsers();
    }

    @Transactional
    public List<Person> listAllPerson() {
        return dao.listAllPerson();
    }

    @Transactional
    public Person insertPerson(Person person)  {
        return dao.insertPerson(person);
    }

    @Transactional
    public Person updatePerson(Person person){
        return   dao.updatePerson(person);
    }

    @Transactional
    public Person updatePerson(Person person, Order orderEntity){
        return   dao.updatePerson(person, orderEntity);
    }

    @Transactional
    public Person getPerson(int id) {
        return dao.getPerson(id);
    }
}
