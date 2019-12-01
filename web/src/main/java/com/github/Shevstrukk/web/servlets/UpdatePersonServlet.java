package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Address;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.PersonService;
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
import java.util.List;


 @WebServlet("/update")
//@Controller
//@RequestMapping
public class UpdatePersonServlet  {
    @Autowired
    DefaultPersonService defaultPersonService;
 //   @GetMapping("/update")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Person person = (Person) defaultPersonService.getPerson(Integer.parseInt(id));
        req.setAttribute("person", person);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/updatePerson.jsp");
        requestDispatcher.forward(req, resp);
    }

   // @PostMapping("/update")
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
        Address addressEntity = new Address(addressId,state, city, street, home,number,null);
        AuthUser user = new AuthUser(idAuth,login,password,role,null);
        Person person = new Person(id,firstName,lastName, user, addressEntity,null,null);
        Person updatePerson = defaultPersonService.updatePerson(person);
        List<Person> personList = defaultPersonService.listAllPerson();

        req.setAttribute("personList", personList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/personList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
