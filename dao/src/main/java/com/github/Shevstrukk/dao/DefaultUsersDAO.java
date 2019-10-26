package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.entity.AuthUser;
import com.github.Shevstrukk.dao.util.EMUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class DefaultUsersDAO implements UsersDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDAO.class);

    public DefaultUsersDAO() {

    }
    private static class SingletonHolder {
        static final UsersDAO HOLDER_INSTANCE = new DefaultUsersDAO();
    }

    public static UsersDAO getInstance() {
        return DefaultUsersDAO.SingletonHolder.HOLDER_INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public List<AuthUser> listAllUsers() {

        EntityManager entityManager = EMUtil.getEntityManager();
        return  entityManager.createQuery("FROM " + AuthUser.class.getName()).getResultList();
    }
    public void saveOrUpdateAuthUser(AuthUser authUser) {
        Session session = EMUtil.getSession();
        session.beginTransaction();
        session.save(authUser);
        session.getTransaction().commit();
        session.close();
    }

}
