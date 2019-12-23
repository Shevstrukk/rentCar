package com.github.Shevstrukk.service;



import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;

import java.util.List;

public interface PersonService {
     Person insertPerson(Person person);
//    public List<AuthUserEntity> listAllAuthUser();
//    public List<Person> listAllPerson();
     List<Person> listAllPerson(int currentPage, int recordsPerPage);
    // public void deletePerson(int person) ;
     Long getCountAllPerson();
     Person updatePerson(Person person) ;
     Person updatePerson(Person person, Order orderEntity) ;
     Person getPerson(int id) ;
     Person getPersonOrderlist(int id) ;
}
