package com.github.Shevstrukk.web.servlets;


import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Address;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.DefaultUserService;
import com.github.Shevstrukk.service.PersonService;
import com.github.Shevstrukk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//@WebServlet("/addPerson")
@Controller
@RequestMapping
public class PersonController {

    private final   UserService userService;
    private final PersonService defaultPersonService;
    @Autowired
    public PersonController(UserService userService, PersonService defaultPersonService) {
        this.userService = userService;
        this.defaultPersonService = defaultPersonService;
    }

    @PostMapping("/addPersonAuth")
    public  String addPerson(HttpServletRequest req)  {
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
        final String state = req.getParameter("state");
        final String city = req.getParameter("city");
        final String street = req.getParameter("street");
        final int home = Integer.valueOf(req.getParameter("home"));
        final int number = Integer.valueOf(req.getParameter("number"));
        Address addressEntity = new Address(null, state, city, street, home, number, null);
        AuthUser authUser = userService.addAuthUser(firstName, lastName);
        Person person = new Person(null, firstName, lastName, authUser, addressEntity, null, null);
        Person person1= defaultPersonService.insertPerson(person);
        AuthUser authUserUpdate = userService.update(authUser.getId(), person1.getId());
        req.getSession().setAttribute("authUserUpdate", authUserUpdate);
        req.getSession().setAttribute("person1", person1);
        return "/phone/addPhoneAuth";
    }

    @GetMapping("/delete")
    public String deletePers(HttpServletRequest req, Model model)  {
        List<Person> personList = defaultPersonService.listAllPerson();
        model.addAttribute("personList", personList);
       // req.setAttribute("personList", personList);
        return "personList";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/personList.jsp");
    }

    @PostMapping("/delete")
    public String doPos(HttpServletRequest req) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        userService.deleteAuthUser(id);
        return "redirect:/delete";
        // doGet(req,resp);
    }

    @GetMapping("/getPerson")
    public String getPersonList(HttpServletRequest req, Model model)  {
        List<Person> personList= defaultPersonService.listAllPerson();
        model.addAttribute("personList", personList);
        return "personList";
    }

    @GetMapping("/update")
    public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Person person = (Person) defaultPersonService.getPerson(Integer.parseInt(id));
        req.setAttribute("person", person);
        return "updatePerson";
    }

    @PostMapping("/update")
    public String updatePerson(HttpServletRequest req, Model model)  {
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
        model.addAttribute("personList", personList);
        return "personList";
    }

}
