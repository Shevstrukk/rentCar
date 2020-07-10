package com.github.shevstrukk.web.servlet.orders;

import com.github.shevstrukk.model.*;
import com.github.shevstrukk.service.CarsService;
import com.github.shevstrukk.service.OrderService;
import com.github.shevstrukk.service.RentalPeriodService;
import com.github.shevstrukk.service.UserService;
import com.github.shevstrukk.service.impl.DefaultCarsService;
import com.github.shevstrukk.service.impl.DefaultOrderService;
import com.github.shevstrukk.service.impl.DefaultRentalPeriodService;
import com.github.shevstrukk.service.impl.DefaultUserService;
import com.github.shevstrukk.web.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RequestMapping
@Controller
public class OrderServlet  {
    @Autowired
    CarsService service;
    @Autowired
    RentalPeriodService periodService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @GetMapping("/getOrder")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        Long idUser = authUser.getUser().getId();
        User user = userService.getUserById(idUser);
        req.setAttribute("user", user);
        WebUtils.forward("user_menu", req, resp);
        return;
    }

    @PostMapping("/getOrder")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        Long userId = authUser.getUser().getId();
        Long carId = Long.valueOf(req.getParameter("carId"));
       Car car = service.getCar(carId);
        String dateStart = req.getParameter("dateStart");
        String dateEnd = req.getParameter("dateEnd");
        java.time.LocalDateTime start = LocalDateTime.parse(dateStart);
        java.time.LocalDateTime end = LocalDateTime.parse(dateEnd);
        RentalPeriod rentalPeriod = periodService.save(new RentalPeriod( null,start, end), carId);
        User user = authUser.getUser();
        int priceSum = car.getPriceDay()*5;
         List cars = new ArrayList();
         Order orderDB = orderService.save(new Order( null, 5, priceSum, LocalDateTime.now(), user, cars), carId);

        doGet(req, resp);
    }
}
