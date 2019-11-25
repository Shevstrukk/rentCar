package com.github.Shevstrukk.web.servlets.phone;

import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;
import com.github.Shevstrukk.service.phoneservice.DefaultPhoneService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deletePhone")
public class DeletePhoneAuth extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = (Person) req.getAttribute("person");
        List<Phone> listPhone = person.getPhones();
        req.setAttribute("phoneList", listPhone);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhoneAuth.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Person person =  DefaultPhoneService.getInstance().deletePhone(id);
        req.setAttribute("person", person);
        doGet(req,resp);
    }
}