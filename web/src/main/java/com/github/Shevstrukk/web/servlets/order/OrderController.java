package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.PersonService;
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


@Controller
@RequestMapping
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService defaultOrderService;
    @Autowired
    CarsService defaultCarsService;
    @Autowired
    PersonService defaultPersonService;

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
        if(authUser ==null){
            authUser=(AuthUser)session.getAttribute("authUser");
        }
        Person person = authUser.getPerson();
        List<Car> cars = new ArrayList<>();
        Car car = defaultCarsService.getCar(carId);
        cars.add(car);
        Order newOrderEntity;
        if (orderEntityOld == null) {
            Order order = new Order(null, rentDay, price, person, cars);
            newOrderEntity = defaultOrderService.saveOrder(order);
            session.setAttribute("order", newOrderEntity);
        } else {
            Order order = defaultOrderService.getOrder(orderEntityOld.getId());
            int newRentDay= order.getRentDay()+rentDay;
            int newPrice = order.getPrice() + price;
            order.setPrice(newPrice);
            order.setRentDay(newRentDay);
            newOrderEntity = defaultOrderService.saveUpdate(order, carId);
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
        return "/order/addOrder";
    }
    @GetMapping("/getOrderList")
    public String getOrderList(HttpServletRequest req, Model model)  {
        HttpSession session = req.getSession();
        AuthUser authUser = (AuthUser)session.getAttribute("authUser");
        if(authUser.getPerson()==null){
            authUser= (AuthUser)session.getAttribute("authUserUpdate");
        }
        int id = authUser.getPerson().getId();
//        Person person =(Person)session.getAttribute("person1");
//        int id = person.getId();
       // Person personList = defaultOrderService.getOrderList(id);// рабочий
        Person personList=defaultPersonService.getPersonOrderlist(id);
        model.addAttribute("personList", personList);
        return "/order/orderList";
    }
    @PostMapping("/getOrderListAuth")
    public String getOrderListAuth(HttpServletRequest req, Model model)  {
        final int id = Integer.parseInt(req.getParameter("id"));
        Person personOrder=defaultPersonService.getPersonOrderlist(id);
        model.addAttribute("personList", personOrder);
        return "/order/orderList";
    }
    @PostMapping("/deleteOrder")
    public String deleteOrder(HttpServletRequest req) {
        final int id = Integer.parseInt(req.getParameter("id"));
        final int personId = Integer.parseInt(req.getParameter("personId"));
        defaultOrderService.deleteOrder(id);
        req.getSession().setAttribute("id", personId);
        return "redirect:deleteOrder";
    }
    @GetMapping("/deleteOrderAuth")
    public String doGet(HttpServletRequest req, Model model)  {
        int id = (int) req.getSession().getAttribute("id");
        Person personList = defaultPersonService.getPersonOrderlist(id);
        model.addAttribute("personList", personList);
        return "/order/orderList";
    }

    @GetMapping("/deleteOrder")
    public String do1Get(HttpServletRequest req, Model model)  {
        int id = (int) req.getSession().getAttribute("id");
        Person personList = defaultPersonService.getPersonOrderlist(id);
        model.addAttribute("personList", personList);
        return "/order/orderList";
    }
    @GetMapping("/addOrder")
    public String addOrder(){
        return "/order/ordersUser";
    }

}
