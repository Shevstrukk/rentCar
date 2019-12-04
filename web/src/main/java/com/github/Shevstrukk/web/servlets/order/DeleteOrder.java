package com.github.Shevstrukk.web.servlets.order;

import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultPersonService;
import com.github.Shevstrukk.service.orderService.DefaultOrderService;
import com.github.Shevstrukk.service.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/deleteOrder")
@Controller
@RequestMapping
public class DeleteOrder  {

    @Autowired
    OrderService defaultOrderService;
//    @PostMapping("/deleteOrder")
//    public String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        final int id = Integer.parseInt(req.getParameter("id"));
//        final int personId = Integer.parseInt(req.getParameter("personId"));
//        defaultOrderService.deleteOrder(id, personId);
//        return "redirect:deleteOrder";
//      //  doGet(req, resp);
//    }
//
//    @GetMapping("/deleteOrder")
//    public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        HttpSession session = req.getSession();
//        AuthUser authUser = (AuthUser)session.getAttribute("authUser");
//        Person person = authUser.getPerson();
//        int id = person.getId();
//        Person personList = defaultOrderService.getOrderList(id);
//        req.setAttribute("personList", personList);
//        return "/order/orderList";
////        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/order/orderList.jsp");
////        requestDispatcher.forward(req, resp);
//    }
}

