package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.dao.entity.AuthUser;
import com.github.Shevstrukk.dao.entity.Order;
import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.service.carService.DefaultCarsService;
import com.github.Shevstrukk.service.orderService.DefaultOrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/getOrderList")
public class GetOrderList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AuthUser authUser = (AuthUser) session.getAttribute("authUser");
        int id = authUser.getPerson().getId();
        System.out.println(id);
        Person personList = DefaultOrderService.getInstance().getOrderList(id);
        req.setAttribute("personList", personList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/order/orderList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
