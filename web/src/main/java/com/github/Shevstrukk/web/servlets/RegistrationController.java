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

// @WebServlet("/regisration")
@Controller
@RequestMapping()
public class RegistrationController {

  private final   UserService userService;
    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String doGet(HttpServletRequest req) {
        Object authUser = req.getSession().getAttribute("authUser");
        if (authUser == null) {
            return "registration";
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/registration.jsp");
//            requestDispatcher.forward(req, resp);
        }return "user_menu";
    }

    @PostMapping("/registration")
    public String doPost(HttpServletRequest req)  {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        AuthUser user = userService.addAuthUser(login, password);
        if(user.getPerson() == null){
//            req.getSession().setAttribute("authUser", user);
//            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, resp);
            return "user_menu";
        }else{
            req.getSession().setAttribute("authUser", user);
            return "/order/orderUser";}
           // req.getRequestDispatcher("/WEB-INF/view/order/ordersUser.jsp").forward(req, resp);}
    }
}
