package com.github.Shevstrukk.web.servlets.car;


import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.service.carService.DefaultCarsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getCarEntities")
public class GetCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> carList = DefaultCarsService.getInstance().getCars();
        req.setAttribute("carEntityList", carList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/car/carEntityList.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
