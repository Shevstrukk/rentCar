package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.converter.AddressConverter;
import com.github.Shevstrukk.dao.converter.PersonConverter;
import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
//import com.github.Shevstrukk.dao.repository.PersonEntityRepository;
import com.github.Shevstrukk.dao.util.EMUtil;

import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DefaultPersonDAO implements PersonDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDAO.class);


   // public PersonEntityRepository repository;

    private final SessionFactory sessionFactory;

    @Autowired
    public DefaultPersonDAO(SessionFactory sessionFactory//, PersonEntityRepository repository
    ) {
        this.sessionFactory = sessionFactory;
      //  this.repository = repository;
    }


    public Person insertPerson(Person person1) {
        PersonEntity person = PersonConverter.toEntity(person1);
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        session.save(person);
        return PersonConverter.fromEntity(person);
    }

    public Person getPerson(int id) {
        PersonEntity person = null;
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        person = session.get(PersonEntity.class, id);
        return PersonConverter.fromEntity(person);
    }
    public Person getPersonOrderList(int id) {
        PersonEntity person = null;
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        person = session.get(PersonEntity.class, id);
        return PersonConverter.fromEntityOrder(person);
    }

//    @Override
//    public List<AuthUserEntity> listAllAuthUsers() {
//        List<AuthUserEntity> list;
//        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
//        String str = "FROM AuthUserEntity  ORDER BY id ASC";
//        list = session.createQuery(str).getResultList();
//        return list;
//    }

//   public List<Person> listAllPersonPage(int currentPage, int recordsPerPage) {
//        int start = currentPage * recordsPerPage - recordsPerPage;
//      //  Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));
//       Pageable pageable = PageRequest.of(start, recordsPerPage);
//        Page<PersonEntity> page = repository.findAll(pageable);
//        List<PersonEntity> list = page.getContent();
//        return PersonConverter.fromListPersonEntity(list);
//
//    }
//    public List<Person> listAllPerson() {
//      //  Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));
//      //  Page<PersonEntity> page = repository.findAll(pageable);
//        List<PersonEntity> list = repository.findAll(Sort.by("id"));
//        return PersonConverter.fromListPersonEntity(list);
//
//    }
    public Long getCountAllPerson(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(
                countQuery.from(PersonEntity.class)));
        Long count = session.createQuery(countQuery).getSingleResult();
        return count;
    }

    public List<Person> listAllPerson(int page, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
//        int page = 1;
//        int pageSize = 4;
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(countQuery.from(PersonEntity.class)));
        Long count = session.createQuery(countQuery).getSingleResult();
        CriteriaQuery<PersonEntity> criteria = cb.createQuery(PersonEntity.class);
        criteria.select(criteria.from(PersonEntity.class));
        TypedQuery<PersonEntity> typedQuery = session.createQuery(criteria);
        typedQuery.setFirstResult(pageSize*(page - 1));          //(pageSize*(page - 1));
        typedQuery.setMaxResults(pageSize);
        List<PersonEntity> personList = typedQuery.getResultList();
        return PersonConverter.fromListPersonEntity(personList);
    }

    public List<Person> listAllPerson() {
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> criteria = cb.createQuery(PersonEntity.class);
        criteria.select(criteria.from(PersonEntity.class));
        List<PersonEntity> list = session.createQuery(criteria).getResultList();
        return PersonConverter.fromListPersonEntity(list);
    }

    public Person updatePerson(Person person) {
        PersonEntity personEntity = PersonConverter.toEntity(person);
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        session.saveOrUpdate(personEntity);
        return PersonConverter.fromEntity(personEntity);
    }

    public Person updatePerson(Person person, Order orderEntity) {
        Person person2;
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        int id = person.getId();
        PersonEntity person1 = session.get(PersonEntity.class, id);
        OrderEntity orderEntity1 = session.get(OrderEntity.class, orderEntity.getId());
        person1.getOrderEntities().add(orderEntity1);
        orderEntity1.setPerson(person1);
        session.saveOrUpdate(person1);
        String str = "FROM  PersonEntity e JOIN FETCH e.orderEntities ordered where e.id =: id";
        Query query = session.createQuery(str);
        query.setParameter("id", id);
        person1 = (PersonEntity) query.getSingleResult();
        person2 = PersonConverter.fromEntityOrder(person1);
        return person2;
    }
}
