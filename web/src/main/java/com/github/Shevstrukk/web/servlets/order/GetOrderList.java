package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.orderService.DefaultOrderService;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

// @WebServlet("/getOrderList")
@Controller
@RequestMapping
public class GetOrderList  {
    @Autowired
    DefaultOrderService defaultOrderService;
    @GetMapping("/getOrderList")
    public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AuthUser authUser = (AuthUser)session.getAttribute("authUser");
        Person person = authUser.getPerson();
        int id = person.getId();
        Person personList = defaultOrderService.getOrderList(id);
        req.setAttribute("personList", personList);
        return "/order/orderList";
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/order/orderList.jsp");
//        requestDispatcher.forward(req, resp);
    }
}
