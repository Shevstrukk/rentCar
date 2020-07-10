package com.github.shevstrukk.web.servlet;

import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.service.SecurityService;
import com.github.shevstrukk.web.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping
public class LoginServlet {
    @Autowired
    private SecurityService security;

    @GetMapping("/login")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
       Object auth = req.getSession().getAttribute("authUser");
       if(auth == null){
           WebUtils.forward("login", req,resp);
           return;
       }
        try {
            resp.sendRedirect(req.getContextPath() +"/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
       String login =req.getParameter("login");
       String password = req.getParameter("password");
        AuthUser authUser = security.getByLogin(login, password);
        if (authUser == null) {
            req.setAttribute("error", "login or password invalid");
            WebUtils.forward("login", req, resp);
            return;
        }else {
            req.getSession().setAttribute("authUser", authUser);
            try {
                resp.sendRedirect(req.getContextPath() + "/user");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
