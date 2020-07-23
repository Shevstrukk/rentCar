package com.github.shevstrukk.web.controller.car;

import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.service.CarsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping
public class CarController {
    private final CarsService carsService;

    public CarController(CarsService carsService) {
        this.carsService = carsService;
    }


    @GetMapping("/getCar")
    public String getCar(HttpServletRequest req, Model model)  {
        List<Car> carList = carsService.getCars();
        model.addAttribute("carEntityList", carList);
        return "carList";
        //return "WEB-INF/view/page/car/carList";
    }

    @PostMapping("/getCar")
    public String doPost(HttpServletRequest req, HttpServletResponse resp)  {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        Long idUser = authUser.getUser().getId();
        Long carId = Long.valueOf(req.getParameter("carId"));
        String dateStart = req.getParameter("startDate");
        String dateEnd = req.getParameter("dateEnd");
        java.time.LocalDateTime start = LocalDateTime.parse(dateStart);
        java.time.LocalDateTime end = LocalDateTime.parse(dateEnd);
        return null;
//??????????????
    }
    @GetMapping("/deleteCar")
    public String deleteCardoGet(HttpServletRequest req, Model model)  {
        List<Car> carList = carsService.getCars();
        model.addAttribute("carEntityList", carList);
       // return "WEB-INF/view/page/car/carList";
        return "carList";
    }

    @PostMapping("/deleteCar")
    public String deleteCardoPost(HttpServletRequest req, HttpServletResponse resp)  {
        Long id = Long.valueOf(req.getParameter("id"));
        carsService.deleteCar(id);
        return "redirect:deleteCar";
    }
    @GetMapping("/updateCar")
    public String updateCar(HttpServletRequest req)  {
        return "carUpdate";
        //return "WEB-INF/view/page/car/carUpdate";
    }
    @PostMapping("/saveUpdateCar")
    public String saveUpdateCardoPost(HttpServletRequest req, Model model ) {
        Long id = Long.valueOf(req.getParameter("id"));
        final  String carModel = req.getParameter("carModel");
        final  String carName = req.getParameter("carName");
        final  int carYear = Integer.valueOf(req.getParameter("carYear"));
        final  String carColor = req.getParameter("carColor");
        final  String carFuel = req.getParameter("carFuel");
        final  int price = Integer.valueOf(req.getParameter("price"));
        final  String comment = req.getParameter("comment");
        Car car = new Car(id, carModel, carName, carYear, carColor, carFuel, price, comment, null, null);
        Car fromDB = carsService.saveCar(car);
        return "redirect:getCar";
    }

    @PostMapping("/updateCar")
    public String updateCardoPost(HttpServletRequest req, Model model ) {
        Long id = Long.valueOf(req.getParameter("id"));
        Car car = carsService.getCar(id);
        model.addAttribute("car", car);
      // return  "WEB-INF/view/page/car/carUpdate";
       return "carUpdate";
    }
    @GetMapping("/addCar")
    public String doGet() {
        return "addCar";
       // return "WEB-INF/view/page/car/addCar";
    }

    @PostMapping("/addCar")
    public String doPost(HttpServletRequest req)  {
        final  String carModel = req.getParameter("carModel");
        final  String carName = req.getParameter("carName");
        final  int carYear = Integer.valueOf(req.getParameter("carYear"));
        final  String carColor = req.getParameter("carColor");
        final  String carFuel = req.getParameter("carFuel");
        final  int price = Integer.valueOf(req.getParameter("price"));
        final  String comment = req.getParameter("comment");
        Car car = new Car(null, carModel, carName, carYear, carColor, carFuel, price, comment, null, null);
        Car fromDB = carsService.saveCar(car);
        return "redirect:/getCar";
        //WebUtils.redirect("getCar", req, resp);

    }
}
