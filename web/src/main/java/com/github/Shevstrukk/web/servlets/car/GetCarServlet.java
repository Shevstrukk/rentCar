package com.github.Shevstrukk.web.servlets.car;


import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.service.carService.DefaultCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

 @WebServlet("/getCars")
//@Controller
//@RequestMapping
public class GetCarServlet  {

    @Autowired
    DefaultCarsService defaultCarsService;
//@GetMapping("/getCars")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> carList = defaultCarsService.getCars();
        req.setAttribute("carEntityList", carList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/car/carList.jsp");
        requestDispatcher.forward(req, resp);
    }

}
