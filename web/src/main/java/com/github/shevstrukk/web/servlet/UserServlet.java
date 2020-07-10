package com.github.shevstrukk.web.servlet;

import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Role;
import com.github.shevstrukk.model.User;
import com.github.shevstrukk.service.AddressService;
import com.github.shevstrukk.service.SecurityService;
import com.github.shevstrukk.service.UserService;
import com.github.shevstrukk.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
@Controller
@RequestMapping
public class UserServlet {
    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/user")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        if(authUser.getRole()== Role.ADMIN){
            List<User> users = userService.getUsers();
            req.setAttribute("users", users);
            WebUtils.forward("user_menu", req, resp);
            return;
        }else {
            User user = authUser.getUser();
            req.setAttribute("user", user);
            WebUtils.forward("user_menu", req, resp);
            return;
        }
    }

    @PostMapping("/user")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        int home = Integer.valueOf(req.getParameter("home"));
        int number = Integer.valueOf(req.getParameter("number"));
        Address address = addressService.saveAddress(new Address(null, country, city, street,home, number, null));
        User user = userService.save(new User(null, firstName, lastName, phone, null, address, null));
        Long authUserId = securityService.saveAuthUser(new AuthUser(null,login, password, Role.USER, user));

        log.info("user created:{} at {}", user, LocalDateTime.now());

        try {
            resp.sendRedirect(req.getContextPath() + "/user");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }

}
