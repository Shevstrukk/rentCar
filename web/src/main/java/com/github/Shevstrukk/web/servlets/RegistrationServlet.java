package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.service.DefaultUserService;
import com.github.Shevstrukk.service.UserService;
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
import java.io.IOException;

@WebServlet("/regisration")
//@Controller
//@RequestMapping
public class RegistrationServlet  {
    @Autowired
    DefaultUserService defaultUserService;
   // @GetMapping("/registration")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object authUser = req.getSession().getAttribute("authUser");
        if (authUser == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/registration.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

   //@PostMapping("/registration")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        AuthUser user = defaultUserService.addAuthUser(login, password);
        if(user.getPerson() == null){
            req.getSession().setAttribute("authUser", user);
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, resp);
        }else{
            req.getSession().setAttribute("authUser", user);
            req.getRequestDispatcher("/WEB-INF/view/order/ordersUser.jsp").forward(req, resp);}
    }
}
