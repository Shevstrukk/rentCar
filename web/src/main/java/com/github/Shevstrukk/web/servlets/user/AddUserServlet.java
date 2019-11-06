package com.github.Shevstrukk.web.servlets.user;


import com.github.Shevstrukk.dao.entity.Address;
import com.github.Shevstrukk.dao.entity.AuthUser;
import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
        final String state = req.getParameter("state");
        final String city = req.getParameter("city");
        final String street = req.getParameter("street");
        final int home = Integer.valueOf(req.getParameter("home"));
        final int number = Integer.valueOf(req.getParameter("number"));
        Address address = new Address(null,state, city, street, home,number);
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        Person person = new Person(null,firstName,lastName,authUser,address,null);
       Person person1= DefaultPersonService.getInstance().insertPerson(person);
        req.getSession().setAttribute("person1", person1);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhone.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* PersonService defaultPersonService= DefaultPersonService.getInstance();
        List<Person> personList = defaultPersonService.listAllPerson();
        req.setAttribute("personList", personList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/user/userList.jsp");
        requestDispatcher.forward(req, resp);*/
    }
}
