package com.github.Shevstrukk.web.servlets.phone;

import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.entity.PhoneEntity;
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

@WebServlet("/addPhoneAuth")
@Controller
@RequestMapping
public class AddPhoneAuthServlet  {
    @Autowired
    DefaultPhoneService defaultPhoneService;

    @GetMapping("/addPhoneAuth")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = (Person) req.getSession().getAttribute("person");
        List<Phone> listPhone = person.getPhones();
        req.setAttribute("phoneList", listPhone);
        req.getSession().setAttribute("person", person);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhoneAuth.jsp");
        requestDispatcher.forward(req, resp);

    }

    @PostMapping("/addPhoneAuth")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String line = String.valueOf(req.getParameter("phoneEntity"));
        Person person1 = (Person) req.getSession().getAttribute("person1");
        int id = person1.getId();
        Phone phoneEntity = new Phone(null,line,null);
        Person person = defaultPhoneService.savePhone(phoneEntity, id);
        req.getSession().setAttribute("person", person);
        doGet(req, resp);
    }
}
