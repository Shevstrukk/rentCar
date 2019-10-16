package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.model.User;
import com.github.Shevstrukk.service.DefaultUserService;
import com.github.Shevstrukk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        UserService userService= DefaultUserService.getInstance();
        User user = userService.login(login, password);

        if (user == null) {
            req.setAttribute("error", "login or password invalid");
            return;
        } else if (user.getRole().equals("admin")){
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, resp);
        }else if(user.getRole().equals("user")){
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, resp);
        }
       // log.info("user {} logged", user.getLogin());
      //  req.getSession().setAttribute("authUser", user);

    }
}
