package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.DataSource;
import com.github.shevstrukk.dao.UserDAO;
import com.github.shevstrukk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultUserDao implements UserDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultUserDao.class);
    private static class SingletonHolder {
        static final UserDAO HOLDER_INSTANCE = new DefaultUserDao();
    }

    public static UserDAO getInstance() {
        return DefaultUserDao.SingletonHolder.HOLDER_INSTANCE;
    }


    @Override
    public List<User> getUsers() {
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from user");
             ResultSet rs = ps.executeQuery()) {
            final ArrayList<User> result = new ArrayList<>();
            while (rs.next()) {
                final User user = new User(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"));
                result.add(user);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long save(User user) {
        final String sql = "insert into user(first_name, last_name, phone) values(?,?,?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPhone());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                keys.next();
                return keys.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserById(Long id) {
        User user = null;
       final String sql = "SELECT * FROM user WHERE id = ?";
        try {Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

             if (resultSet.next()) {
                final long resultId = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phone = resultSet.getString("phone");
                user = new User(resultId, firstName, lastName, phone);
             }
            }
        catch (SQLException e){
            log.error("fail getUserById user:{}", e);
            throw new RuntimeException(e);
        }
        return user;
    }

}
