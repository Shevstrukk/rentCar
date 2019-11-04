package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.dao.entity.Address;
import com.github.Shevstrukk.dao.entity.AuthUser;
import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.DefaultUserService;
import com.github.Shevstrukk.service.PersonService;
import com.github.Shevstrukk.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/update")
public class UpdatePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
       Person person = (Person) DefaultPersonService.getInstance().getPerson(Integer.parseInt(id));
        req.setAttribute("person", person);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/updatePerson.jsp");
        requestDispatcher.forward(req, resp);
    }

         @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            final  int idAuth = Integer.valueOf(req.getParameter("idAuth"));
             final  int addressId = Integer.valueOf(req.getParameter("addressId"));
             final String firstName = req.getParameter("firstName");
             final String lastName = req.getParameter("lastName");
             final String state = req.getParameter("state");
             final String city = req.getParameter("city");
             final String street = req.getParameter("street");
             final int home = Integer.valueOf(req.getParameter("home"));
             final int number = Integer.valueOf(req.getParameter("number"));
             final int id = Integer.valueOf(req.getParameter("id"));
             final String login = req.getParameter("login");
             final String password = req.getParameter("password");
             final String role = req.getParameter("role");
             Address address = new Address(addressId,state, city, street, home,number);
             //UserService userService= DefaultUserService.getInstance();
            // AuthUser user = userService.login(firstName, lastName);
             // AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
             AuthUser user = new AuthUser(idAuth,login,password,role,null);
             Person person = new Person(id,firstName,lastName, user,address,null);
             DefaultPersonService.getInstance().updatePerson(person);

            PersonService defaultPersonService= DefaultPersonService.getInstance();
             List<Person> personList = defaultPersonService.listAllPerson();

             req.setAttribute("personList", personList);
             RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/personList.jsp");
             requestDispatcher.forward(req, resp);
         }
}
