package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.service.ConfigService;
import com.github.Shevstrukk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Controller
@RequestMapping
public class LogoutController  {
    private static final Logger log = LoggerFactory.getLogger(LogoutController.class);
    private final UserService userService;

    @Autowired
    public LogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logout")
    public  String doGet(HttpSession session)  {
        session.removeAttribute("authUser");
        session.invalidate();
        return "login";
    }

}

