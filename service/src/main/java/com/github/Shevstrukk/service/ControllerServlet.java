package com.github.Shevstrukk.service;

import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControllerServlet extends HttpServlet {
    private static final long serialversionUID = 1L;
    private PersonDAO personDAO;

    public void init() {
       // ResourceBundle resource = ResourceBundle.getBundle("db");
        //String jdbcURL = resource.getString("url");
        String jdbcURL = "jdbc:mysql://localhost:3306/people?logger=com.mysql.cj.log.StandardLogger&profileSQL=true";
       // String jdbcUsername = resource.getString("user");
        String jdbcUsername = "root";
       // String jdbcPassword = resource.getString("password");
        String jdbcPassword = "vitalij84";
       /* String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword"); */
        personDAO = new PersonDAO(jdbcURL,jdbcUsername, jdbcPassword);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertPerson(request, response);
                    break;
                case "/delete":
                    deletePerson(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updatePerson(request, response);
                    break;
                default:
                    listPerson(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listPerson (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Person> listPerson = personDAO.listAllPerson();
        request.setAttribute("listPerson", listPerson);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("personList.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("personForm.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Person existingPerson = personDAO.getPerson(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("personForm.jsp");
        request.setAttribute("person", existingPerson);
        dispatcher.forward(request, response);

    }
    private void insertPerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int rentDay = Integer.parseInt(request.getParameter("rentDay"));

        Person person = new Person(firstName,lastName, rentDay);
        personDAO.insertPerson(person);
        response.sendRedirect("list");
    }
    private void updatePerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int rentDay = Integer.parseInt(request.getParameter("rentDay"));

        Person person = new Person(id, firstName, lastName, rentDay);
        personDAO.updatePerson(person);
        response.sendRedirect("list");
    }
    private void deletePerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Person person = new Person(id);
        personDAO.deletePerson(person);
        response.sendRedirect("list");

    }
}
