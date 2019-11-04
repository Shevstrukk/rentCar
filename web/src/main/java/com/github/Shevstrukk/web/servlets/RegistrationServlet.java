package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.dao.entity.AuthUser;
import com.github.Shevstrukk.service.DefaultUserService;
import com.github.Shevstrukk.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regisration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object authUser = req.getSession().getAttribute("authUser");
        if (authUser == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/registration.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        UserService userService= DefaultUserService.getInstance();
        AuthUser user = userService.login(login, password);
        if(user.getPerson()==null){
            req.getSession().setAttribute("authUser", user);
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, resp);
        }else{
        req.getSession().setAttribute("authUser", user);
        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);}
    }
}
