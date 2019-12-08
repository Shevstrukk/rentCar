package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.converter.AuthUserConverter;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.AuthUser;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class DefaultAuthUsersDAO implements AuthUsersDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDAO.class);
    private  final SessionFactory sessionFactory;
    @Autowired
    public DefaultAuthUsersDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;    }



    @SuppressWarnings("unchecked")
    public List<AuthUser> listAllUsers() {
        List<AuthUserEntity> list;
        String str = "FROM AuthUserEntity  ORDER BY id ASC";
//        Session session = EMUtil.getSession();
//        session.beginTransaction();
        Session session = sessionFactory.getCurrentSession();
        list = session.createQuery(str).getResultList();
//        session.getTransaction().commit();
//        session.close();
        return AuthUserConverter.fromListAuthUserEntity(list);
    }

    public AuthUser saveOrUpdateAuthUser(AuthUser authUser) {
        AuthUserEntity authUserEntity= AuthUserConverter.toEntity(authUser);
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
//        session.beginTransaction();
        session.save(authUserEntity);
//        session.getTransaction().commit();
//        session.close();
        return AuthUserConverter.fromEntity(authUserEntity);
    }
    public AuthUser saveAuthUserLogin(AuthUser authUser) {
        AuthUserEntity authUserEntity= AuthUserConverter.toEntityLogin(authUser);
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
//        session.beginTransaction();
        session.save(authUserEntity);
//        session.getTransaction().commit();
//        session.close();
        return AuthUserConverter.fromEntity(authUserEntity);
    }
    public void deleteAuthUser (int id){
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession())

            AuthUserEntity authUserEntity = session.get(AuthUserEntity.class, id);


                session.delete(authUserEntity);


//        Session session = EMUtil.getSession();
//        session.beginTransaction();
//        AuthUserEntity authUserEntity = session.get(AuthUserEntity.class, id);
//        session.delete(authUserEntity);
//        session.getTransaction().commit();
//        session.close();
    }
    public AuthUser update(int id, int personId){
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
//        session.beginTransaction();
        AuthUserEntity authUserEntity = session.get(AuthUserEntity.class, id);
        PersonEntity personEntity = session.get(PersonEntity.class, personId);
        authUserEntity.setPerson(personEntity);
        session.update(authUserEntity);
//        session.getTransaction().commit();
//        session.close();
        return AuthUserConverter.fromEntityAuth(authUserEntity);

    }
}

