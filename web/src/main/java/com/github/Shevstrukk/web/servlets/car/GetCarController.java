package com.github.Shevstrukk.web.servlets.car;


import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.service.carService.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping
public class GetCarController {
        @Autowired
        CarsService defaultCarsService;
        @GetMapping("/getCarsAuth")
        protected String doGet(HttpServletRequest req, Model model) {
            List<Car> carList = defaultCarsService.getCars();
            model.addAttribute("carEntityList", carList);
           // req.setAttribute("carEntityList", carList);
            return "/car/carList";
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/car/carList.jsp");
//            requestDispatcher.forward(req, resp);
        }

    }

