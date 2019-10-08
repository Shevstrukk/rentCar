package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DefaultPersonDAO implements PersonDAO{
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDAO.class);

    String jdbcURL;
    String jdbcUsername;
    String jdbcPassword;

    public DefaultPersonDAO(){

        ResourceBundle resources = ResourceBundle.getBundle("db");
         jdbcURL = resources.getString("url");
         jdbcUsername = resources.getString("user");
         jdbcPassword = resources.getString("password");

    }
    private static class SingletonHolder {
        static final PersonDAO HOLDER_INSTANCE = new DefaultPersonDAO();
    }

    public static PersonDAO getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    Connection jdbcConnection;

    protected void connect() throws SQLException {

        if (jdbcConnection == null || jdbcConnection.isClosed()) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
               throw new RuntimeException(e);
            }
            jdbcConnection = DriverManager.getConnection( jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertPerson(Person person) throws SQLException {
        String sql = "INSERT INTO person ( first_name, last_name, rent_day) VALUES (?, ?, ?)";
            connect();


        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, person.getFirstName());
        statement.setString(2, person.getLastName());
        statement.setFloat(3, person.getRentDay());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    public List<Person> listAllPerson() throws SQLException {
        List<Person> listPerson = new ArrayList<>();

        String sql = "SELECT * FROM person";

            connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("person_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int rentDay = resultSet.getInt("rent_day");

            Person person = new Person(id, firstName, lastName, rentDay);
            listPerson.add(person);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listPerson;
    }
    public boolean deletePerson(Person person) throws SQLException {
        String sql = "DELETE FROM people where person_id = ?";

            connect();


        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, person.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
    public boolean updatePerson(Person person) throws SQLException {
        String sql = "UPDATE person SET first_name = ?, last_name = ?, rent_day = ?";
        sql += " WHERE person_id = ?";
            connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, person.getFirstName());
        statement.setString(2, person.getLastName());
        statement.setInt(3, person.getRentDay());
        statement.setInt(4, person.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
    public Person getPerson(int id) throws SQLException {
        Person person = null;
        String sql = "SELECT * FROM person WHERE person_id = ?";

            connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int rentDay  = resultSet.getInt("rent_day");

            person = new Person(id,firstName, lastName, rentDay );
        }

        resultSet.close();
        statement.close();

        return person;
    }
}
