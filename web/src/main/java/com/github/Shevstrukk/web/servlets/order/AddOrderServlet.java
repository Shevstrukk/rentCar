package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.carService.DefaultCarsService;
import com.github.Shevstrukk.service.orderService.DefaultOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/doOrder")
public class AddOrderServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(AddOrderServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/order/ordersUser.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        final int carId = Integer.parseInt(req.getParameter("carId"));
        final int rentDay = Integer.parseInt(req.getParameter("rentDay"));
        final int price = Integer.parseInt(req.getParameter("price"));
        Car carEntity = DefaultCarsService.getInstance().getCar(carId);
        Order orderEntityOld = (Order) session.getAttribute("order");
        Person person = (Person) session.getAttribute("person");
        List<Car> carEntities = new ArrayList<>();
        Order newOrderEntity;
        if (orderEntityOld == null) {
            Order orderEntity = new Order(null, rentDay, price, person, carEntities);
            newOrderEntity = DefaultOrderService.getInstance().saveOrder(orderEntity, carEntity);
            session.setAttribute("order", newOrderEntity);
        } else {
            int newPrice = orderEntityOld.getPrice() + price;
            orderEntityOld.setPrice(newPrice);
           newOrderEntity = DefaultOrderService.getInstance().saveOrUpdate(orderEntityOld, carEntity);
        }
        Person person1 = DefaultPersonService.getInstance().updatePerson(person, newOrderEntity);
        doGet(req,resp);
    }
}
