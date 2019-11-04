package com.github.Shevstrukk.web.servlets.user;

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

@WebServlet("/newUser")
public class NewUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/user/newUser.jsp");
        requestDispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
        final int rentDay = Integer.valueOf(req.getParameter("rentDay"));
        Person person = new Person(null,firstName,lastName,rentDay);
      /*  DefaultPersonService.getInstance().insertPerson(person);
        PersonService defaultPersonService= DefaultPersonService.getInstance();
        List<Person> personList = defaultPersonService.listAllPerson();

        req.setAttribute("personList", personList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/user/userList.jsp");
        requestDispatcher.forward(req, resp);*/

    }

}
