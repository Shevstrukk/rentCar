package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.converter.AuthUserConverter;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.AuthUser;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class DefaultAuthUsersDAO implements AuthUsersDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDAO.class);

    public DefaultAuthUsersDAO() {

    }
    private static class SingletonHolder {
        static final AuthUsersDAO HOLDER_INSTANCE = new DefaultAuthUsersDAO();
    }

    public static AuthUsersDAO getInstance() {
        return DefaultAuthUsersDAO.SingletonHolder.HOLDER_INSTANCE;
    }

   @SuppressWarnings("unchecked")
    public List<AuthUser> listAllUsers() {
       /* EntityManager entityManager = EMUtil.getEntityManager();
        return AuthUserConverter.fromListAuthUserEntity
                (entityManager.createQuery("FROM " + AuthUserEntity.class.getName()).getResultList());*/
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

    public void deleteAuthUser (int id){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        AuthUserEntity authUserEntity = session.get(AuthUserEntity.class, id);
        session.delete(authUserEntity);
        session.getTransaction().commit();
        session.close();
    }
}
