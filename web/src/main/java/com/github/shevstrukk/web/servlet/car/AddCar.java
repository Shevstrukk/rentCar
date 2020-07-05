package com.github.shevstrukk.web.servlet.car;

import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.service.CarsService;
import com.github.shevstrukk.service.impl.DefaultCarsService;
import com.github.shevstrukk.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCar")
public class AddCar extends HttpServlet {
    CarsService service = DefaultCarsService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebUtils.forward("view/car/addCar",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
