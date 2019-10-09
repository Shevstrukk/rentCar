package com.github.Shevstrukk.web.servlets;


import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/addPerson")
public class AddPersonServlet extends HttpServlet {

    private static final long serialversionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      PersonService defaultPersonService= DefaultPersonService.getInstance();
      List<Person> personList = null;
        try {
             personList= defaultPersonService.listAllPerson();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("personList", personList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/personList.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
        final int rentDay = Integer.valueOf(req.getParameter("rentDay"));
        Person person = new Person(firstName,lastName,rentDay);
        try {
            DefaultPersonService.getInstance().insertPerson(person);
        }catch (SQLException e){
            e.printStackTrace();
        }doGet(req,resp);
    }

}
