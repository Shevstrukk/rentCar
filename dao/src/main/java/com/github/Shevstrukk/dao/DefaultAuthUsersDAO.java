package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.converter.AuthUserConverter;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.AuthUser;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class DefaultAuthUsersDAO implements AuthUsersDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDAO.class);

    public DefaultAuthUsersDAO() {    }

    @SuppressWarnings("unchecked")
    public List<AuthUser> listAllUsers() {
        List<AuthUserEntity> list;
        String str = "FROM AuthUserEntity  ORDER BY id ASC";
        Session session = EMUtil.getSession();
        session.beginTransaction();
        list = session.createQuery(str).getResultList();
        session.getTransaction().commit();
        session.close();
        return AuthUserConverter.fromListAuthUserEntity(list);
    }

    public AuthUser saveOrUpdateAuthUser(AuthUser authUser) {
        AuthUserEntity authUserEntity= AuthUserConverter.toEntity(authUser);
        Session session = EMUtil.getSession();
        session.beginTransaction();
        session.save(authUserEntity);
        session.getTransaction().commit();
        session.close();
        return AuthUserConverter.fromEntity(authUserEntity);
    }
    public AuthUser saveAuthUserLogin(AuthUser authUser) {
        AuthUserEntity authUserEntity= AuthUserConverter.toEntityLogin(authUser);
        Session session = EMUtil.getSession();
        session.beginTransaction();
        session.save(authUserEntity);
        session.getTransaction().commit();
        session.close();
        return AuthUserConverter.fromEntity(authUserEntity);
    }
    public void deleteAuthUser (int id){
        try(Session session = EMUtil.getSession()){
            AuthUserEntity authUserEntity = session.get(AuthUserEntity.class, id);

            if(authUserEntity != null){
                log.info("authUserNotNull*********");
                session.beginTransaction();
                session.delete(authUserEntity);
                session.getTransaction().commit();
                session.close();
            } else {
                System.out.println(" no authUser--------");
            }
        } catch (HibernateException e){
            log.error("Authuser not found by id{}", id);
        }

//        Session session = EMUtil.getSession();
//        session.beginTransaction();
//        AuthUserEntity authUserEntity = session.get(AuthUserEntity.class, id);
//        session.delete(authUserEntity);
//        session.getTransaction().commit();
//        session.close();
    }
    public AuthUser update(int id, int personId){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        AuthUserEntity authUserEntity = session.get(AuthUserEntity.class, id);
        PersonEntity personEntity = session.get(PersonEntity.class, personId);
        authUserEntity.setPerson(personEntity);
        session.update(authUserEntity);
        session.getTransaction().commit();
        session.close();
        return AuthUserConverter.fromEntityAuth(authUserEntity);

    }
}

