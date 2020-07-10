package com.github.shevstrukk.web.servlet.car;

import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.service.CarsService;
import com.github.shevstrukk.service.impl.DefaultCarsService;
import com.github.shevstrukk.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping
public class DeleteCarServlet  {
    private static final Logger log = LoggerFactory.getLogger(DeleteCarServlet.class);
    @Autowired
    CarsService service;
    @GetMapping("/deleteCar")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        List<Car> carList = service.getCars();
        req.setAttribute("carEntityList", carList);
        WebUtils.forward("view/car/carList",req, resp);
    }

    @PostMapping("/deleteCar")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        Long id = Long.valueOf(req.getParameter("id"));
        service.deleteCar(id);
        doGet(req, resp);
    }
}
