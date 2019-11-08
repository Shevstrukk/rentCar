package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.entity.Address;
import com.github.Shevstrukk.dao.entity.AuthUser;
import com.github.Shevstrukk.dao.entity.Order;
import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.util.EMUtil;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DefaultPersonDAO implements PersonDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDAO.class);
    public DefaultPersonDAO() {
    }

    private static class SingletonHolder {
        static final PersonDAO HOLDER_INSTANCE = new DefaultPersonDAO();
    }

    public static PersonDAO getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public Person insertPerson(Person person) {
        Session session = EMUtil.getSession();
        session.beginTransaction();
        AuthUser authUser = person.getAuthUser();
        Address address = person.getAddress();
        session.save(address);
        authUser.setPerson(person);
        person.setAddress(address);
        session.save(person);
        session.saveOrUpdate(authUser);
        session.getTransaction().commit();
        session.close();
        return person;
    }
    public Person getPerson(int id) {
        Person person = null;
        Session session = EMUtil.getSession();
        session.beginTransaction();
        person = session.get(Person.class, id);
        session.getTransaction().commit();
        session.close();
        return person;
        //String sql = "SELECT * FROM person WHERE person_id = ?";
    }

    @Override
    public List<AuthUser> listAllAuthUsers() {
        List<AuthUser> list;
        Session session = EMUtil.getSession();
        session.beginTransaction();
        String str = "FROM AuthUser  ORDER BY id ASC";
        list = session.createQuery(str).getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public List<Person> listAllPerson() {
        Session session = EMUtil.getSession();
        int pageNamber = 1;
        int pageSize = 4;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
        criteria.select(criteria.from(Person.class));
        TypedQuery<Person> typedQuery = session.createQuery(criteria);
        typedQuery.setFirstResult(pageSize*(pageNamber-1));
        typedQuery.setMaxResults(pageSize);
        List<Person>  personList = typedQuery.getResultList();
//        Root<Person> rootPerson = criteria.from(Person.class);
//        criteria.select(rootPerson);
       // List<Person> list = session.createQuery(criteria).getResultList();

/*   рабочий код
//        List<Person> list;
//        Session session = EMUtil.getSession();
//        session.beginTransaction();
//       // String str = "FROM Person  ORDER BY id ASC";
//        String str = "FROM  Person e JOIN FETCH e.phones phon";
//        list = session.createQuery(str).getResultList();
//        session.getTransaction().commit();
//        session.close();*/
        return personList;
    }
    public void updatePerson(Person person){
        int id = person.getId();
        Session session = EMUtil.getSession();
        session.beginTransaction();
        Person person1 = session.get(Person.class,id);
        person1.setFirstName(person.getFirstName());
        person1.setLastName(person.getLastName());
        person1.setAddress(person.getAddress());
        session.saveOrUpdate(person1);
        session.getTransaction().commit();
        session.close();
    }
    public Person updatePerson(Person person, Order order){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        int id = person.getId();
        Person person1 = session.get(Person.class, id);
        Order order1 = session.get(Order.class, order.getId());
        person1.getOrders().add(order1);
        order1.setPerson(person1);
        session.saveOrUpdate(person1);
        String str = "FROM  Person e JOIN FETCH e.orders ordered where e.id =: id";
        Query query =  session.createQuery(str);
        query.setParameter("id", id);
        person1 =(Person)query.getSingleResult();
       // session.saveOrUpdate(person1);
        session.getTransaction().commit();
        session.close();
        return person1;
    }
}
