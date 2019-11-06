package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.dao.entity.Car;
import com.github.Shevstrukk.dao.entity.Order;
import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.carService.DefaultCarsService;
import com.github.Shevstrukk.service.orderService.DefaultOrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/doOrder")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/order/orderUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        final int carId = Integer.parseInt(req.getParameter("carId"));
        final  int rentDay = Integer.parseInt(req.getParameter("rentDay"));
        final int price = Integer.parseInt(req.getParameter("price"));
        Car car = DefaultCarsService.getInstance().getCar(carId);
        Order orderOld = (Order)session.getAttribute("order");
        Person person =(Person)session.getAttribute("person");
        List<Car> cars = new ArrayList<>();
        Order newOrder;
        if(orderOld==null){
            Order order = new Order(null,rentDay,price,person,cars);
             newOrder= DefaultOrderService.getInstance().saveOrder(order, car);
            session.setAttribute("order", newOrder);
        } else {
            int newPrice = orderOld.getPrice()+ price;
            orderOld.setPrice(newPrice);
            newOrder=DefaultOrderService.getInstance().saveOrder(orderOld, car);
            session.setAttribute("order", newOrder);
        }
      //  Person person1 = DefaultPersonService.getInstance().updatePerson(person, newOrder);

       // doGet(req,resp);
    }
}
