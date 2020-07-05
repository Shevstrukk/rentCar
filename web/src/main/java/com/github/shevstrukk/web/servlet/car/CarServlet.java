package com.github.shevstrukk.web.servlet.car;

import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.service.impl.DefaultCarsService;
import com.github.shevstrukk.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/getCar")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> carList = DefaultCarsService.getInstance().getCars();
        req.setAttribute("carEntityList", carList);
        WebUtils.forward("view/car/carList",req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        Long idUser = authUser.getUser().getId();
        Long carId = Long.valueOf(req.getParameter("carId"));
//        String string = "2011-03-22";
//        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(string);
        String dateStart = req.getParameter("startDate");
        String dateEnd = req.getParameter("dateEnd");
        java.time.LocalDateTime start = LocalDateTime.parse(dateStart);
        java.time.LocalDateTime end = LocalDateTime.parse(dateEnd);


    }
}
