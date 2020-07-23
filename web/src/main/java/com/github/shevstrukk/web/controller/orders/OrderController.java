package com.github.shevstrukk.web.controller.orders;

import com.github.shevstrukk.model.*;
import com.github.shevstrukk.service.CarsService;
import com.github.shevstrukk.service.OrderService;
import com.github.shevstrukk.service.RentalPeriodService;
import com.github.shevstrukk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RequestMapping
@Controller
public class OrderController {

    CarsService service;

    RentalPeriodService periodService;

    UserService userService;

    OrderService orderService;

    public OrderController(CarsService service, RentalPeriodService periodService, UserService userService, OrderService orderService) {
        this.service = service;
        this.periodService = periodService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/getOrder")
    public String doGet(HttpServletRequest req, Model model)  {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        Long idUser = authUser.getUser().getId();
        User user = userService.getUserById(idUser);
        model.addAttribute("user", user);
       return "user_menu";
        //return "WEB-INF/view/page/user_menu";
    }

    @PostMapping("/getOrder")
    public String doPost(HttpServletRequest req)  {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        Long userId = authUser.getUser().getId();
        Long carId = Long.valueOf(req.getParameter("carId"));
       Car car = service.getCar(carId);
        String dateStart = req.getParameter("dateStart");
        String dateEnd = req.getParameter("dateEnd");
        java.time.LocalDateTime start = LocalDateTime.parse(dateStart);
        java.time.LocalDateTime end = LocalDateTime.parse(dateEnd);
        Duration duration = Duration.between(start, end);
        int diff =(int)Math.abs(duration.toHours());
        RentalPeriod rentalPeriod = periodService.save(new RentalPeriod( null,start, end), carId);
        User user = authUser.getUser();
        int priceSum = car.getPriceDay()*diff;
         List cars = new ArrayList();

         Order orderDB = orderService.save(new Order( null, diff, priceSum, LocalDateTime.now(), user, cars), carId);
         return "redirect:/getOrder";

    }
    @PostMapping("/deleteOrder")
    public String deleteOrder(HttpServletRequest req)  {
        Long orderId = Long.valueOf(req.getParameter("orderId"));
        orderService.deleteOrder(orderId);
        return "redirect:/user";

    }
}
