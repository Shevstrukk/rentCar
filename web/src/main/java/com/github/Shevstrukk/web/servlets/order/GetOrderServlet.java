package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.service.carService.CarsService;
import com.github.Shevstrukk.service.carService.DefaultCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @WebServlet("/getOrder")
@Controller
@RequestMapping
public class GetOrderServlet  {
//    @Autowired
//    CarsService defaultCarsService;
//
//    @PostMapping("/getOrder")
//    public String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        final int id = Integer.parseInt(req.getParameter("id"));
//        final int rentDay = Integer.parseInt(req.getParameter("rentDay"));
//
//        Car carEntity = defaultCarsService.getCar(id);
//        int price = rentDay* carEntity.getPriceDay();
//        req.setAttribute("carEntity", carEntity);
//        req.setAttribute("price", price);
//        req.setAttribute("rentDay", rentDay);
//        return "/order/addOrder";
////        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/order/addOrder.jsp");
////        requestDispatcher.forward(req, resp);
//    }
}
