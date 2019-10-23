package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


}
