package com.github.Shevstrukk.web.servlets.phone;

import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.entity.PhoneEntity;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;
import com.github.Shevstrukk.service.PersonService;
import com.github.Shevstrukk.service.phoneservice.DefaultPhoneService;
import com.github.Shevstrukk.service.phoneservice.PhoneService;
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

//@WebServlet("/addPhoneAuth")
@Controller
@RequestMapping
public class PhoneController {
    @Autowired
    PersonService personService;
    @Autowired
    PhoneService defaultPhoneService;

    @GetMapping("/addPhoneAuth")
    public String addPhoneAuth(HttpServletRequest req, Model model)  {
        Person person = (Person) req.getSession().getAttribute("person");
        List<Phone> listPhone = person.getPhones();
        model.addAttribute("phoneList", listPhone);
        //req.setAttribute("phoneList", listPhone);
        req.getSession().setAttribute("person", person);
        return "/phone/addPhoneAuth";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhoneAuth.jsp");
//        requestDispatcher.forward(req, resp);

    }
    @PostMapping("/addPhoneAuth")
    public String addPhoneAuthPost(HttpServletRequest req)  {
        final String line = String.valueOf(req.getParameter("phoneEntity"));
        Person person1 = (Person) req.getSession().getAttribute("person1");
        int id = person1.getId();
        Phone phoneEntity = new Phone(null,line,null);
        Person person = defaultPhoneService.savePhone(phoneEntity, id);
        req.getSession().setAttribute("person", person);
        return "redirect:/addPhoneAuth";
      //  doGet(req, resp);
    }

    @GetMapping("/addPhone")
    public String addPhone(HttpServletRequest req)  {
        Person person = (Person) req.getSession().getAttribute("person");
        List<Phone> listPhoneEntity = person.getPhones();
        req.getSession().setAttribute("phoneList", listPhoneEntity);
        req.getSession().setAttribute("person", person);
        return "/phone/addPhone";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhone.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @PostMapping("/addPhone")
    public String addPhonePost(HttpServletRequest req)  {
        final String line = String.valueOf(req.getParameter("phoneEntity"));
        Person person1 = (Person) req.getSession().getAttribute("person1");
        int id = person1.getId();
        Phone phoneEntity = new Phone(null,line,null);
        Person person = defaultPhoneService.savePhone(phoneEntity, id);
        req.getSession().setAttribute("person", person);
        return "redirect:/addPhone";
       // doGet(req, resp);
    }

    @GetMapping("/deletePhone")
    public String doGet(HttpServletRequest req)  {
        Person person = (Person) req.getSession().getAttribute("person1");
        int id = person.getId();
        Person personPhone = personService.getPerson(id);
        List<Phone> listPhone = personPhone.getPhones();
        req.setAttribute("phoneList", listPhone);
        return "/phone/addPhoneAuth";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhoneAuth.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @PostMapping("/deletePhone")
    public String deletephone(HttpServletRequest req)  {
        int id = Integer.parseInt(req.getParameter("id"));
        Person person =  defaultPhoneService.deletePhone(id);
        req.setAttribute("person", person);
        return "redirect:/deletePhone";
//        doGet(req,resp);
    }
}
