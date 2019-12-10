package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.carService.CarsService;
import com.github.Shevstrukk.service.orderService.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// @WebServlet("/doOrder")
@Controller
@RequestMapping
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService defaultOrderService;
    @Autowired
    CarsService defaultCarsService;

    @GetMapping("/doOrder")
    public String doGet(HttpServletRequest req) {
        return "order/ordersUser";
    }

    @PostMapping("/doOrder")
    public String doPost(HttpServletRequest req)  {
        HttpSession session = req.getSession();
        final int carId = Integer.parseInt(req.getParameter("carId"));
        final int rentDay = Integer.parseInt(req.getParameter("rentDay"));
        final int price = Integer.parseInt(req.getParameter("price"));
        Order orderEntityOld = (Order) session.getAttribute("order");
        AuthUser authUser = (AuthUser)session.getAttribute("authUserUpdate");
        Person person = authUser.getPerson();
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
        return "redirect:/doOrder";
    }

    @PostMapping("/getOrder")
    public String addOrder(HttpServletRequest req, Model model)  {
        final int id = Integer.parseInt(req.getParameter("id"));
        final int rentDay = Integer.parseInt(req.getParameter("rentDay"));
        Car carEntity = defaultCarsService.getCar(id);
        int price = rentDay* carEntity.getPriceDay();
        model.addAttribute("carEntity", carEntity);
        model.addAttribute("price", price);
        model.addAttribute("rentDay", rentDay);
//        req.setAttribute("carEntity", carEntity);
//        req.setAttribute("price", price);
//        req.setAttribute("rentDay", rentDay);
        return "/order/addOrder";
    }
    @GetMapping("/getOrderList")
    public String getOrderList(HttpServletRequest req, Model model)  {
        HttpSession session = req.getSession();
       // AuthUser authUser = (AuthUser)session.getAttribute("authUser");
     //   int id = authUser.getPerson().getId();
        Person person =(Person)session.getAttribute("person1");

        int id = person.getId();
        Person personList = defaultOrderService.getOrderList(id);
        model.addAttribute("personList", personList);
       // req.setAttribute("personList", personList);
        return "/order/orderList";
    }
    @PostMapping("/deleteOrder")
    public String deleteOrder(HttpServletRequest req) {
        final int id = Integer.parseInt(req.getParameter("id"));
        final int personId = Integer.parseInt(req.getParameter("personId"));
        defaultOrderService.deleteOrder(id, personId);
        return "redirect:deleteOrder";
    }

    @GetMapping("/deleteOrder")
    public String do1Get(HttpServletRequest req, Model model)  {
        HttpSession session = req.getSession();
        AuthUser authUser = (AuthUser)session.getAttribute("authUserUpdate");
        Person person = authUser.getPerson();
        int id = person.getId();
        Person personList = defaultOrderService.getOrderList(id);
        model.addAttribute("personList", personList);
//        req.setAttribute("personList", personList);
        return "/order/orderList";
    }
}
