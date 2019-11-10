package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.service.carService.DefaultCarsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getOrder")
public class GetOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         final int id = Integer.parseInt(req.getParameter("id"));
         final int rentDay = Integer.parseInt(req.getParameter("rentDay"));

        Car carEntity = DefaultCarsService.getInstance().getCar(id);
         int price = rentDay* carEntity.getPriceDay();
        req.setAttribute("carEntity", carEntity);
        req.setAttribute("price", price);
        req.setAttribute("rentDay", rentDay);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/order/addOrder.jsp");
        requestDispatcher.forward(req, resp);
    }
}
