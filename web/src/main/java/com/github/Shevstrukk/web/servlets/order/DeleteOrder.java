package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.orderService.DefaultOrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOrder")
public class DeleteOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int id = Integer.parseInt(req.getParameter("id"));
        final int personId = Integer.parseInt(req.getParameter("personId"));
        Person person =  DefaultOrderService.getInstance().deleteOrder(id, personId);
        req.setAttribute("personList", person);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/order/orderList.jsp");
        requestDispatcher.forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

