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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
@Controller
@RequestMapping
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    private SecurityService securityService;

    private AddressService addressService;

    public UserController(UserService userService, SecurityService securityService, AddressService addressService) {
        this.userService = userService;
        this.securityService = securityService;
        this.addressService = addressService;
    }

    @GetMapping("/user")
    public String doGet(HttpServletRequest req, Model model)  {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        if(authUser.getRole()== Role.ADMIN){
            List<User> users = userService.getUsers();
            model.addAttribute("users", users);
           // WebUtils.forward("user_menu", req, resp);
            return "WEB-INF/view/page/user_menu";
        }else {
            User user = authUser.getUser();
            model.addAttribute("user", user);
          //  WebUtils.forward("user_menu", req, resp);
            return "WEB-INF/view/page/user_menu";
        }
    }

    @PostMapping("/user")
    public String doPost(HttpServletRequest req) {
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
        return "redirect:/user";
    }

}
