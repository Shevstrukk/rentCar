package com.github.shevstrukk.web.servlet.car;

import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.service.CarsService;
import com.github.shevstrukk.service.impl.DefaultCarsService;
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
import java.util.List;

@WebServlet("/getCar")
@Controller
@RequestMapping
public class CarServlet  {
    @Autowired
    CarsService carsService;
    @GetMapping("/getCar")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        List<Car> carList = carsService.getCars();
        req.setAttribute("carEntityList", carList);
        WebUtils.forward("view/car/carList",req, resp);
    }

    @PostMapping("/getCar")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        Long idUser = authUser.getUser().getId();
        Long carId = Long.valueOf(req.getParameter("carId"));
        String dateStart = req.getParameter("startDate");
        String dateEnd = req.getParameter("dateEnd");
        java.time.LocalDateTime start = LocalDateTime.parse(dateStart);
        java.time.LocalDateTime end = LocalDateTime.parse(dateEnd);


    }
}
