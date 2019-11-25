package com.github.Shevstrukk.web.servlets.user;


import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Address;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.DefaultUserService;
import com.github.Shevstrukk.service.address.DefaultAddressService;

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

        Address address = DefaultAddressService.getInstance().saveAddress(new Address(null,state, city, street, home,number,null));
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        Person person = new Person(null,firstName,lastName, authUser, address,null,null);
        Person person1= DefaultPersonService.getInstance().insertPerson(person);
        req.getSession().setAttribute("person1", person1);
        AuthUser authUserUpdate = DefaultUserService.getInstance().update(authUser.getId(), person1.getId());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhone.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* PersonService defaultPersonService= DefaultPersonService.getInstance();
        List<PersonEntity> personList = defaultPersonService.listAllPerson();
        req.setAttribute("personList", personList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/user/userList.jsp");
        requestDispatcher.forward(req, resp);*/
    }
}