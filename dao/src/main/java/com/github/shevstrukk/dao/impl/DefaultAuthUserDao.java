package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.AuthUserDao;
import com.github.shevstrukk.dao.DataSource;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Role;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DefaultAuthUserDao implements AuthUserDao {

    private static class SingletonHolder {
        static final AuthUserDao HOLDER_INSTANCE = new DefaultAuthUserDao();
    }

    public static AuthUserDao getInstance() {
        return DefaultAuthUserDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public AuthUser getByLogin(String login) {
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from auth_user where login = ?")) {
            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new AuthUser(
                            rs.getLong("id"),
                            rs.getString("login"),
                            rs.getString("password"),
                            Role.valueOf(rs.getString("role")),
                            rs.getLong("user_id"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long saveAuthUser(AuthUser user) {
        final String sql = "insert into auth_user(login, password, role, user_id) values(?,?,?,?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole().name());
            ps.setLong(4, user.getUserId());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if(generatedKeys.next()){
                return generatedKeys.getLong(1);}
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
