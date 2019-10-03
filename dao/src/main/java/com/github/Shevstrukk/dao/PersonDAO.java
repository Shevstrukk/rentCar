package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PersonDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public PersonDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
      //  String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        //Class.forName("com.mysql.cj.jdbc.Driver");

    }
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {

            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
         /*   ResourceBundle resource = ResourceBundle.getBundle("db");
            String url = resource.getString("url");
            String user = resource.getString("user");
            String pass = resource.getString("password");

            try {
               Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);*/
        }
    }
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    public boolean insertPerson(Person person) throws SQLException {
        String sql = "INSERT INTO person (person_id, first_name, last_name) VALUES (?, ?, ?)";
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
