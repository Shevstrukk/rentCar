package com.github.shevstrukk.web.servlet;

import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.service.SecurityService;
import com.github.shevstrukk.service.impl.DefaultSecurityService;
import com.github.shevstrukk.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private SecurityService security = DefaultSecurityService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Object auth = req.getSession().getAttribute("authUser");
       if(auth == null){
           WebUtils.forword("login", req,resp);
           return;
       }
        try {
            resp.sendRedirect(req.getContextPath() +"/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String login =req.getParameter("login");
       String password = req.getParameter("password");
        AuthUser authUser = security.getByLogin(login, password);
        if (authUser == null) {
            req.setAttribute("error", "login or password invalid");
            WebUtils.forword("login", req, resp);
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
