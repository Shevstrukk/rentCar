package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Address;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.DefaultUserService;
import com.github.Shevstrukk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @WebServlet("/newPerson")
@Controller
@RequestMapping
public class NewPersonServlet   {
    @Autowired
    DefaultUserService defaultUserService;
    @Autowired
    DefaultPersonService defaultPersonService;
    @GetMapping("/newPerson")
    public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "newPerson";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/newPerson.jsp");
//        requestDispatcher.forward(req, resp);
    }
    @PostMapping("/newPerson")
    public String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
        final String state = req.getParameter("state");
        final String city = req.getParameter("city");
        final String street = req.getParameter("street");
        final int home = Integer.valueOf(req.getParameter("home"));
        final int number = Integer.valueOf(req.getParameter("number"));
        Address addressEntity = new Address(null,state, city, street, home,number, null);
        AuthUser user = defaultUserService.login(firstName, lastName);
        Person person = new Person(null,firstName,lastName, user, addressEntity,null,null);
        Person person1= defaultPersonService.insertPerson(person);
        req.getSession().setAttribute("person1", person1);
        return "/phone/addPhoneAuth";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhoneAuth.jsp");
//        requestDispatcher.forward(req, resp);
    }
}