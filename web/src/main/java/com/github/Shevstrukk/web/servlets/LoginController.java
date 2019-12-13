package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;

import com.github.Shevstrukk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;


//@WebServlet("/login")
@Controller
@RequestMapping
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String doGet(HttpServletRequest rq) {
        //  Object authUser = rq.getSession().getAttribute("authUser");
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null)
            return "login";

        return "registration";
    }

    @PostMapping("/login")
    public String doPost(HttpServletRequest rq, Model model) {

        final String login = rq.getParameter("login");
        final String password = rq.getParameter("password");
        AuthUser user = userService.login(login, password);

        if (user == null) {
            // rq.setAttribute("error", "login or password invalid");
            model.addAttribute("error", "login or password invalid");
            return "login";
        }
        log.info("user {} logged", user.getLogin());
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, getAuthorities(user.getRole()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "redirect:/addPersonAuth";
    }

    private List<GrantedAuthority> getAuthorities(String role) {
        switch (role) {
            case "admin":
                return Arrays.asList((GrantedAuthority) () -> "ROLE_admin",
                        (GrantedAuthority) () -> "ROLE_user");
            case "user":
                return Arrays.asList((GrantedAuthority) () -> "ROLE_user");
            default: throw new RuntimeException();
        }

    }
}



