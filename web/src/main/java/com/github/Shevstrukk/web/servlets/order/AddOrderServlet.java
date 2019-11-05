package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.dao.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addOrder")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int carId = Integer.parseInt(req.getParameter("arId"));
        final  int rentDay = Integer.parseInt(req.getParameter("rentDay"));
        final int price = Integer.parseInt(req.getParameter("price"));
        HttpSession session = req.getSession();
        Person person =(Person)session.getAttribute("person");
        int personId = person.getId();
    }
}
