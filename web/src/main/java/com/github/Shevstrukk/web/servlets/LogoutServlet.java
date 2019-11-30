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
public class LogoutServlet extends HttpServlet {

    @GetMapping("/login")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        final HttpSession session = req.getSession();

        session.removeAttribute("authUser");
        // session.removeAttribute("login");
        // session.removeAttribute("role");
        session.invalidate();

        resp.sendRedirect(super.getServletContext().getContextPath()+"/");
    }

}

