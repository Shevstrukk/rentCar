package com.github.Shevstrukk.web.servlets.phone;

import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.entity.Phone;
import com.github.Shevstrukk.service.phoneservice.DefaultPhoneService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addPhoneAuth")
public class AddPhoneAuthServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Person person = (Person) req.getSession().getAttribute("person");
            List<Phone> listPhone = person.getPhones();
            req.getSession().setAttribute("phoneList", listPhone);
            req.getSession().setAttribute("person", person);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/phone/addPhoneAuth.jsp");
            requestDispatcher.forward(req, resp);

        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            final String line = String.valueOf(req.getParameter("phone"));
            Person person1 = (Person) req.getSession().getAttribute("person1");
            int id = person1.getId();
            Phone phone = new Phone(null,line,null);
            Person person = DefaultPhoneService.getInstance().savePhone(phone, id);
            req.getSession().setAttribute("person", person);
            doGet(req, resp);
        }
}
