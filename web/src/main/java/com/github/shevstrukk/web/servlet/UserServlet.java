package com.github.shevstrukk.web.servlet;

import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Role;
import com.github.shevstrukk.model.User;
import com.github.shevstrukk.service.SecurityService;
import com.github.shevstrukk.service.UserService;
import com.github.shevstrukk.service.impl.DefaultSecurityService;
import com.github.shevstrukk.service.impl.DefaultUserService;
import com.github.shevstrukk.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);
    private UserService userService = DefaultUserService.getInstance();
    private SecurityService securityService = DefaultSecurityService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        if(authUser.getRole()== Role.ADMIN){
            List<User> users = userService.getUsers();
            req.setAttribute("users", users);
            WebUtils.forward("user_menu", req, resp);
            return;
        }else {
            User user = userService.getUserById(authUser.getUserId());
            req.setAttribute("user", user);
            WebUtils.forward("user_menu", req, resp);
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        Long id = userService.save(new User(null, firstName, lastName, phone));
        Long authUserId = securityService.saveAuthUser(new AuthUser(null,firstName, lastName, Role.USER, id));

        log.info("user created:{} at {}", id, LocalDateTime.now());

        try {
            resp.sendRedirect(req.getContextPath() + "/user");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }

}
