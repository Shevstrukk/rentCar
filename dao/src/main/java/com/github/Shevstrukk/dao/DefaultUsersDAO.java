package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.dao.entity.User;
import com.github.Shevstrukk.dao.util.EMUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
    public List<User> listAllUsers() {
        List<User> userList;
        EntityManager entityManager = EMUtil.getEntityManager();
        return userList= entityManager.createQuery("FROM " + User.class.getName()).getResultList(); }


}
