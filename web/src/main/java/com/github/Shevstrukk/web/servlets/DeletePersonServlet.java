package com.github.Shevstrukk.web.servlets;


import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.DefaultUserService;

import com.github.Shevstrukk.service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/delete")
public class DeletePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //UserService defaultUserService = DefaultUserService.getInstance();
       // List<AuthUserEntity> authUserList = defaultUserService.listAllUsers();
        PersonService defaultPersonService = DefaultPersonService.getInstance();
        List<Person> personList = defaultPersonService.listAllPerson();
        req.setAttribute("personList", personList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/personList.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Integer id = Integer.parseInt(req.getParameter("id"));
      //  PersonEntity person = new PersonEntity(id);
            DefaultUserService.getInstance().deleteAuthUser(id);
            doGet(req,resp);
    }
    }
