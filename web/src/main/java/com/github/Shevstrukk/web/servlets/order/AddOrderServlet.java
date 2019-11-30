package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.carService.DefaultCarsService;
import com.github.Shevstrukk.service.orderService.DefaultOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// @WebServlet("/doOrder")
@Controller
@RequestMapping
public class AddOrderServlet  {
    private static final Logger log = LoggerFactory.getLogger(AddOrderServlet.class);
    @Autowired
    DefaultOrderService defaultOrderService;
    @GetMapping("/doOrder")
    protected String doGet(HttpServletRequest req) {
        return "/order/orderUser";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/order/ordersUser.jsp");
//        requestDispatcher.forward(req, resp);
    }
    @PostMapping("/doOrder")
    protected String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        final int carId = Integer.parseInt(req.getParameter("carId"));
        final int rentDay = Integer.parseInt(req.getParameter("rentDay"));
        final int price = Integer.parseInt(req.getParameter("price"));
        //  Car car = DefaultCarsService.getInstance().getCar(carId);
        Order orderEntityOld = (Order) session.getAttribute("order");
        Person person = (Person) session.getAttribute("person");
        List<Car> carEntities = new ArrayList<>();
        Order newOrderEntity;
        if (orderEntityOld == null) {
            Order order = new Order(null, rentDay, price, person, carEntities);
            newOrderEntity = defaultOrderService.saveOrder(order, carId);
            session.setAttribute("order", newOrderEntity);
        } else {
            int newPrice = orderEntityOld.getPrice() + price;
            orderEntityOld.setPrice(newPrice);
            newOrderEntity = defaultOrderService.saveUpdate(orderEntityOld, carId);
        }
        // Person person1 = DefaultPersonService.getInstance().updatePerson(person, newOrderEntity);
//        doGet(req,resp);
        return "redirect:/doOrder";
    }
}
