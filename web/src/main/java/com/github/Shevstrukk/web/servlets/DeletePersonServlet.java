package com.github.Shevstrukk.web.servlets;


import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.DefaultUserService;

import com.github.Shevstrukk.service.PersonService;
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
import java.util.List;


//@WebServlet("/delete")
@Controller
@RequestMapping
public class DeletePersonServlet  {
    @Autowired
    PersonService defaultPersonService;
    @Autowired
    UserService defaultUserService;
    @GetMapping("/delete")
    public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> personList = defaultPersonService.listAllPerson();
        req.setAttribute("personList", personList);
        return "personList";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/personList.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @PostMapping("/delete")
    public String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        defaultUserService.deleteAuthUser(id);
        return "redirect:/delete";
       // doGet(req,resp);
    }
}
