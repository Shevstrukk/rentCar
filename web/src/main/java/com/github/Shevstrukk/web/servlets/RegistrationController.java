package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.service.DefaultUserService;
import com.github.Shevstrukk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


@Controller
@RequestMapping()
public class RegistrationController {
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    UserService userService;
    @GetMapping("/registration")
    public String doGet(HttpServletRequest req) {
        Object authUser = req.getSession().getAttribute("authUser");
        if (authUser == null) {
            return "registration";
        }return "user_menu";
    }

    @PostMapping("/registration")
    public String doPost(HttpServletRequest req)  {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        AuthUser user = userService.addAuthUser(login, password);
            req.getSession().setAttribute("authUser", user);
            return "user_menu";
        }

}
