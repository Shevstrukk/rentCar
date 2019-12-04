package com.github.Shevstrukk.web.servlets;

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
public class LogoutServlet  {

    @GetMapping("/logout")
    protected String doGet(HttpServletRequest req)  {

        final HttpSession session = req.getSession();
        session.removeAttribute("authUser");
        // session.removeAttribute("login");
        // session.removeAttribute("role");
        session.invalidate();
        return "login";

//        resp.sendRedirect(super.getServletContext().getContextPath()+"/");
    }

}

