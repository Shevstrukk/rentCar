package com.github.Shevstrukk.web.servlets.phone;

import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;
import com.github.Shevstrukk.service.phoneservice.DefaultPhoneService;
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

//@WebServlet("/deletePhone")
@Controller
@RequestMapping
public class DeletePhoneAuth  {
    @Autowired
    DefaultPhoneService defaultPhoneService;
    @GetMapping("/deletePhone")
    public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = (Person) req.getAttribute("person");
        List<Phone> listPhone = person.getPhones();
        req.setAttribute("phoneList", listPhone);
        return "/phone/addPhoneAuth";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhoneAuth.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @PostMapping("/deletePhone")
    public String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Person person =  defaultPhoneService.deletePhone(id);
        req.setAttribute("person", person);
        return "redirect:/deletePhone";
//        doGet(req,resp);
    }
}