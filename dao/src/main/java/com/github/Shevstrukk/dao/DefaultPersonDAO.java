package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.entity.Address;
import com.github.Shevstrukk.dao.entity.AuthUser;
import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.util.EMUtil;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        List<Person> list;
        Session session = EMUtil.getSession();
        session.beginTransaction();
       // String str = "FROM Person  ORDER BY id ASC";
        String str = "FROM  Person e JOIN FETCH e.phones phon";
        list = session.createQuery(str).getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
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
}
