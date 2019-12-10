package com.github.Shevstrukk.web.servlets.car;


import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.service.carService.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping
public class GetCarController {
        @Autowired
        CarsService defaultCarsService;
        @GetMapping("/getCarsAuth")
        public String doGet(HttpServletRequest req, Model model) {
            List<Car> carList = defaultCarsService.getCars();
            model.addAttribute("carEntityList", carList);
           // req.setAttribute("carEntityList", carList);
            return "/car/carList";
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/car/carList.jsp");
//            requestDispatcher.forward(req, resp);
        }
        @GetMapping("/addCar")
        public String addCar(HttpServletRequest request, Model model){
            List<Car> carList = defaultCarsService.getCars();
                    model.addAttribute("carEntityList", carList);
            return "car/addCar";
        }
     @PostMapping("/addCar")
        public String addCarNew(HttpServletRequest request){
             final String carName = request.getParameter("carName");
             final int carYear = Integer.parseInt(request.getParameter("carYear"));
             final String carColor = request.getParameter("carColor");
             final  int priceDay = Integer.parseInt(request.getParameter("price"));
             final String comment = request.getParameter("comment");
             Car car = new Car(null, carName, carYear, carColor, priceDay, comment, null);
             Car newcar = defaultCarsService.create(car);
        return "redirect:/addCar";
    }
    @GetMapping("/updateCar")
    public String updateGet(HttpServletRequest request, Model model){
           final  int id = Integer.parseInt(request.getParameter("id"));
           Car car = defaultCarsService.getCar(id);
           model.addAttribute("car", car);
           return "car/updateCar";
    }
    @PostMapping("/updateCar")
    public String updateCar(HttpServletRequest request){
            final int id = Integer.parseInt(request.getParameter("id"));
            final String carName = request.getParameter("carName");
            final int carYear = Integer.parseInt(request.getParameter("carYear"));
            final String carColor = request.getParameter("carColor");
            final  int priceDay = Integer.parseInt(request.getParameter("price"));
            final String comment = request.getParameter("comment");
//            final int carYear = Integer.parseInt(request.getParameter("carYear"));
            Car car = new Car(id, carName, carYear, carColor, priceDay, comment, null);
            Car newcar = defaultCarsService.update(car);
            return "redirect:/addCar";
    }
    @PostMapping("/deleteCar")
    public String delete(HttpServletRequest request){
        final int id = Integer.parseInt(request.getParameter("id"));

        defaultCarsService.delete(id);
        return "redirect:/addCar";
    }

    }

