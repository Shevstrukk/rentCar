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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RegistrationServlet.class);
    private SecurityService security = DefaultSecurityService.getInstance();
    private UserService userService = DefaultUserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        AuthUser authUser = security.isExist( login);
        if (authUser!=null){
            req.setAttribute("error", "login is Exist");
                        WebUtils.forward("registration", req, resp);
                        return;
        }else {
            Long id = userService.save(new User(null, firstName, lastName, phone));
            log.info("user created:{} at {}", id, LocalDateTime.now());
            Long authId = security.saveAuthUser(new AuthUser(null, login, password, Role.USER, id));
            log.info("authUser created:{} at {}", id, LocalDateTime.now());
            req.getSession().setAttribute("authUser", authUser);
        }


        try {
            resp.sendRedirect(req.getContextPath() + "/user");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }
    // if (authUser == null) {
    //            req.setAttribute("error", "login or password invalid");
    //            WebUtils.forward("login", req, resp);
    //            return;
    //        }else {
    //            req.getSession().setAttribute("authUser", authUser);
    //            try {
    //                resp.sendRedirect(req.getContextPath() + "/user");
    //            } catch (IOException e) {
    //                throw new RuntimeException(e);
    //            }
    //        }
}
