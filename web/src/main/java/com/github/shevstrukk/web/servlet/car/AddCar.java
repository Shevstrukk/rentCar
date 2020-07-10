package com.github.shevstrukk.web.servlet.car;

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

@WebServlet("/addCar")
@Controller
@RequestMapping
public class AddCar {
    @Autowired
    CarsService service;
    @GetMapping("/addCar")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        WebUtils.forward("view/car/addCar",req,resp);
    }

    @PostMapping("/addCar")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        final  String carModel = req.getParameter("carModel");
        final  String carName = req.getParameter("carName");
        final  int carYear = Integer.valueOf(req.getParameter("carYear"));
        final  String carColor = req.getParameter("carColor");
        final  String carFuel = req.getParameter("carFuel");
        final  int price = Integer.valueOf(req.getParameter("price"));
        final  String comment = req.getParameter("comment");
        Car car = new Car(null, carModel, carName, carYear, carColor, carFuel, price, comment, null, null);
        Car fromDB = service.saveCar(car);
        WebUtils.redirect("getCar", req, resp);

    }
}
