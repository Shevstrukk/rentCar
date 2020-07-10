package com.github.shevstrukk.web.servlet.car;

import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.service.CarsService;
import com.github.shevstrukk.service.SecurityService;
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

@WebServlet("/updateCar")
@RequestMapping
@Controller
public class UpdateCarServlet  {
    @Autowired
    CarsService service;
    @GetMapping("/updateCar")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        WebUtils.forward("view/car/carUpdate", req,resp);
        return;
    }

    @PostMapping("/updateCar")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.valueOf(req.getParameter("id"));
        Car car = service.getCar(id);
        req.setAttribute("car", car);
        doGet(req, resp);
    }
}
