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

    String jdbcURL;
    String jdbcUsername;
    String jdbcPassword;

    public DefaultUsersDAO() {

        ResourceBundle resources = ResourceBundle.getBundle("db");
        jdbcURL = resources.getString("url");
        jdbcUsername = resources.getString("user");
        jdbcPassword = resources.getString("password");

    }

    private static class SingletonHolder {
        static final UsersDAO HOLDER_INSTANCE = new DefaultUsersDAO();
    }

    public static UsersDAO getInstance() {
        return DefaultUsersDAO.SingletonHolder.HOLDER_INSTANCE;
    }

    Connection jdbcConnection;

    protected void connect() throws SQLException {

        if (jdbcConnection == null || jdbcConnection.isClosed()) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    public List<User> listAllUsers() {
        List<User> listUser = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            connect();
            Statement statement = jdbcConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");

                User user = new User(id, login, password, role );
                listUser.add(user);
                log.info("user saved: {}", user);
            }
            resultSet.close();
            statement.close();

            disconnect();
        } catch (SQLException e) {
            log.error("fail return Listperson:{}", listUser, e);
            throw new RuntimeException();
        }
        return listUser;
    }

    public User getByLogin( String login)  {
       User user = null;
        String sql = "SELECT * FROM users WHERE login = ?";
        try {
            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               long id =  resultSet.getLong("id");
               String login1 = resultSet.getString("login");
               String password =  resultSet.getString("password");
               String role = resultSet.getString("role");
               user = new User(id, login, password, role);
            }else {return null;}
            resultSet.close();
            statement.close();}
        catch (SQLException e){
            log.error("fail get user:{}", user, e);
            throw new RuntimeException(e);
        }
          return user;
    }
}
