package com.github.shevstrukk.web.controller;

import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.model.Role;
import com.github.shevstrukk.model.User;
import com.github.shevstrukk.service.AddressService;
import com.github.shevstrukk.service.SecurityService;
import com.github.shevstrukk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
@Controller
@RequestMapping
public class RegistrationController {
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    private final SecurityService security;
    private final UserService userService;
    private final AddressService addressService;

    public RegistrationController(SecurityService security, UserService userService, AddressService addressService) {
        this.security = security;
        this.userService = userService;
        this.addressService = addressService;
    }

    @GetMapping("/registration")
    public String doGet()  {
        return "registration";
       // return "WEB-INF/view/page/registration";
    }

    @PostMapping("/registration")
    public String doPost(HttpServletRequest req, HttpServletResponse resp) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        int home = Integer.valueOf(req.getParameter("home"));
        int number = Integer.valueOf(req.getParameter("number"));
        AuthUser authUser = security.isExist(login);
        if (authUser != null) {
            req.setAttribute("error", "login is Exist");
            //return "WEB-INF/view/page/registration";
            return "login";
        } else {
            Address address = addressService.saveAddress(new Address(null, country, city, street, home, number, null));
            User user = userService.save(new User(null, firstName, lastName, phone, null, address, null));
            log.info("user created:{} at {}", user, LocalDateTime.now());
            Long authId = security.saveAuthUser(new AuthUser(null, login, password, Role.USER, user));
            log.info("authUser created:{} at {}", user, LocalDateTime.now());
            req.getSession().setAttribute("authUser", authUser);
        }
        return "redirect:/user";
    }

}
