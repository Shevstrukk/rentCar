package com.github.Shevstrukk.dao;



import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;

import java.util.List;


public interface PersonDAO {
    public Person insertPerson(Person person);
//    public List<AuthUserEntity> listAllAuthUsers();
    public List<Person> listAllPerson();
    public List<Person> listAllPerson(int currentPage, int recordsPerPage);
    /*  public boolean deletePerson(long person) ;*/
    public Person updatePerson(Person person) ;
    public Person updatePerson(Person person, Order orderEntity) ;
    public Person getPerson(int id) ;
    public Person getPersonOrderList(int id) ;
    public Long getCountAllPerson();
}
