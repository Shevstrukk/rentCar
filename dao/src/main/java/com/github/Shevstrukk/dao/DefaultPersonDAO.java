package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.converter.AddressConverter;
import com.github.Shevstrukk.dao.converter.PersonConverter;
import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.util.EMUtil;

import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DefaultPersonDAO implements PersonDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDAO.class);
    private final SessionFactory sessionFactory;
    @Autowired
    public DefaultPersonDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;
    }

    public Person insertPerson(Person person1) {
        PersonEntity person = PersonConverter.toEntity(person1);
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
//        session.beginTransaction();
        //  AuthUserEntity authUserEntity = person.getAuthUserEntity();
        //  AddressEntity addressEntity = person.getAddressEntity();
        //  session.save(addressEntity);
        // authUserEntity.setPerson(person);
        //  person.setAddressEntity(addressEntity);
        session.save(person);
        // session.saveOrUpdate(authUserEntity);
//        session.getTransaction().commit();
//        session.close();
        return PersonConverter.fromEntity(person);
    }
    public Person getPerson(int id) {
        PersonEntity person = null;
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        person = session.get(PersonEntity.class, id);
        return PersonConverter.fromEntity(person);
        //String sql = "SELECT * FROM person WHERE person_id = ?";
    }

    @Override
    public List<AuthUserEntity> listAllAuthUsers() {
        List<AuthUserEntity> list;
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        String str = "FROM AuthUserEntity  ORDER BY id ASC";
        list = session.createQuery(str).getResultList();
        return list;
    }
//    public List<PersonEntity> pagePerson(int page) {
//        Session session = EMUtil.getSession();
//        int pageNamber = 1;
//        int pageSize = 4;
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<PersonEntity> criteria = cb.createQuery(PersonEntity.class);
//        criteria.select(criteria.from(PersonEntity.class));
//        TypedQuery<PersonEntity> typedQuery = session.createQuery(criteria);
//        typedQuery.setFirstResult(pageSize*(page - 1)
//                .setMaxResults(pazeSize);
//        List<PersonEntity> personList = typedQuery.getResultList();
//    }

    public List<Person> listAllPerson() {
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
//        int pageNamber = 1;
//        int pageSize = 4;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> criteria = cb.createQuery(PersonEntity.class);
        criteria.select(criteria.from(PersonEntity.class));
        //TypedQuery<PersonEntity> typedQuery = session.createQuery(criteria);
        // List<PersonEntity>  personList = typedQuery.getResultList();
//        Root<PersonEntity> rootPerson = criteria.from(PersonEntity.class);
//        criteria.select(rootPerson);
        List<PersonEntity> list = session.createQuery(criteria).getResultList();

//   рабочий код
     /*   List<PersonEntity> list;
        Session session = EMUtil.getSession();
        session.beginTransaction();
       // String str = "FROM PersonEntity  ORDER BY id ASC";
        String str = "FROM  PersonEntity e JOIN FETCH e.phoneEntities phon";
        list = session.createQuery(str).getResultList();
        session.getTransaction().commit();
        session.close();*/
        return PersonConverter.fromListPersonEntity(list);
    }
    public Person updatePerson(Person person){
        PersonEntity personEntity = PersonConverter.toEntity(person);
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        session.saveOrUpdate(personEntity);
        return PersonConverter.fromEntity(personEntity);
    }
    public Person updatePerson(Person person, Order orderEntity){
        Person person2;
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        int id = person.getId();
        PersonEntity person1 = session.get(PersonEntity.class, id);
        OrderEntity orderEntity1 = session.get(OrderEntity.class, orderEntity.getId());
        person1.getOrderEntities().add(orderEntity1);
        orderEntity1.setPerson(person1);
        session.saveOrUpdate(person1);
        String str = "FROM  PersonEntity e JOIN FETCH e.orderEntities ordered where e.id =: id";
        Query query =  session.createQuery(str);
        query.setParameter("id", id);
        person1 =(PersonEntity)query.getSingleResult();
        person2=PersonConverter.fromEntityOrder(person1);
        return person2;
    }
}
