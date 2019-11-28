package com.github.Shevstrukk.dao.base;

import org.hibernate.Session;

import javax.persistence.EntityManagerFactory;
import java.io.Serializable;

public class BaseDao<T> implements Dao {
    private final Class<T> clazz;
    private final EntityManagerFactory factory;

    public BaseDao(Class<T> clazz, EntityManagerFactory factory) {
        this.clazz = clazz;
        this.factory = factory;
    }

    @Override
    public T save(T t) {
        final Session session = getSession();
        session.beginTransaction();
        session.persist(t);
        session.getTransaction().commit();
        return t;
    }

    @Override
    public T get(Serializable id) {
        return getSession().find(clazz, id);
    }

    @Override
    public T update(T t) {
        final Session session = getSession();
        session.beginTransaction();
        session.merge(t);
        session.getTransaction().commit();
        return t;
    }

    @Override
    public void delete(Serializable id) {
        final Session session = getSession();
        session.beginTransaction();
        T t = session.find(clazz, id);
        session.remove(t);
        session.getTransaction().commit();
    }

    public Session getSession() {
        return factory.createEntityManager().unwrap(Session.class);
    }

}
