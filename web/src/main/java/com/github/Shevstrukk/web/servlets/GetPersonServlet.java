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
import java.sql.SQLException;
import java.util.List;
@WebServlet("/getPerson")
public class GetPersonServlet extends HttpServlet {
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
}
