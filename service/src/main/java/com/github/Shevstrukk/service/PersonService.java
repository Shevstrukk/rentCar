package com.github.Shevstrukk.service;



import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;

import java.util.List;

public interface PersonService {
    public Person insertPerson(Person person);
    public List<AuthUserEntity> listAllAuthUser();
    public List<Person> listAllPerson();
    // public void deletePerson(int person) ;
    public Person updatePerson(Person person) ;
    public Person updatePerson(Person person, Order orderEntity) ;
    public Person getPerson(int id) ;
}
