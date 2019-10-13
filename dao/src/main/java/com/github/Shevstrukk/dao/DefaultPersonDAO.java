package com.github.Shevstrukk.dao;

import com.github.Shevstrukk.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DefaultPersonDAO implements PersonDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPersonDAO.class);

    String jdbcURL;
    String jdbcUsername;
    String jdbcPassword;

    public DefaultPersonDAO() {

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
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public Person insertPerson(Person person) {
        String sql = "INSERT INTO person ( first_name, last_name, rent_day) VALUES (?, ?, ?)";
        try {
            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setFloat(3, person.getRentDay());
            //boolean rowInserted =
            statement.executeUpdate();
            //  return rowInserted;
            final ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            final long id = generatedKeys.getInt(1);
            final Person personInsert = new Person(id, person.getFirstName(), person.getLastName(), person.getRentDay());
            log.info("person saved: {}", personInsert);
            statement.close();
            disconnect();
            return personInsert;
        } catch (SQLException e) {
            log.error("fail to insert person salary:{}", person, e);
            throw new RuntimeException(e);
        }
    }

    public List<Person> listAllPerson() {
        List<Person> listPerson = new ArrayList<>();
        String sql = "SELECT * FROM person";
        try {
            connect();
            Statement statement = jdbcConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getInt("person_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int rentDay = resultSet.getInt("rent_day");

                Person person = new Person(id, firstName, lastName, rentDay);
                listPerson.add(person);
                log.info("person saved: {}", person);
            }
            resultSet.close();
            statement.close();

            disconnect();
        } catch (SQLException e) {
            log.error("fail return Listperson:{}", listPerson, e);
            throw new RuntimeException();
        }
        return listPerson;
    }

    public boolean deletePerson(long person)  {


        String sql = "DELETE FROM person where person_id = ?";
        boolean rowDeleted=false;
        try {
            connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
       // statement.setInt(1, person.getId());
            statement.setLong(1, person);

        rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();

      } catch (SQLException e) {
            log.error("fail delete person:{}", rowDeleted, e);
            throw new RuntimeException(e);
      }
        return rowDeleted;
    }

    public boolean updatePerson(Person person)  {
        String sql = "UPDATE person SET first_name = ?, last_name = ?, rent_day = ?";
        sql += " WHERE person_id = ?";
        boolean rowUpdated=false;
        try {
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, person.getFirstName());
        statement.setString(2, person.getLastName());
        statement.setInt(3, person.getRentDay());
        statement.setLong(4, person.getId());
        rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
            return rowUpdated;
        }catch (SQLException e){
            log.error("fail update person:{}", rowUpdated, e);
            throw new RuntimeException(e);
        }

    }

    public Person getPerson(long id)  {
        Person person = null;
        String sql = "SELECT * FROM person WHERE person_id = ?";
        try {
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            final long resultId = resultSet.getInt("person_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int rentDay = resultSet.getInt("rent_day");
            person = new Person(resultId, firstName, lastName, rentDay);
        }
        resultSet.close();
        statement.close();}
        catch (SQLException e){
            log.error("fail update person:{}", person, e);
            throw new RuntimeException(e);
        }
        return person;
    }
}
