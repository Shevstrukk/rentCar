package com.github.shevstrukk.web.servlet.car;

import com.github.shevstrukk.dao.CarDao;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.service.CarsService;
import com.github.shevstrukk.service.impl.DefaultCarsService;
import com.github.shevstrukk.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DeleteCarServlet.class);
    CarsService service = DefaultCarsService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> carList = DefaultCarsService.getInstance().getCars();
        req.setAttribute("carEntityList", carList);
        WebUtils.forward("view/car/carList",req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        service.deleteCar(id);
        doGet(req, resp);
    }
}
