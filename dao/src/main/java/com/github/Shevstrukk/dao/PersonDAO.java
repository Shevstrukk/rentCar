package com.github.Shevstrukk.dao;



import com.github.Shevstrukk.dao.entity.AuthUser;
import com.github.Shevstrukk.dao.entity.Order;
import com.github.Shevstrukk.dao.entity.Person;

import java.util.List;


public interface PersonDAO {
    public Person insertPerson(Person person);
   public List<AuthUser> listAllAuthUsers();
    public List<Person> listAllPerson();
  /*  public boolean deletePerson(long person) ;*/
    public void updatePerson(Person person) ;
    public Person updatePerson(Person person, Order order) ;
    public Person getPerson(int id) ;
}
