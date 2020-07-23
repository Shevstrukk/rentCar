package com.github.shevstrukk.web.controller;

import com.github.shevstrukk.model.AuthUser;
import com.github.shevstrukk.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private final SecurityService security;

    public LoginController(SecurityService security) {
        this.security = security;
    }

    @GetMapping("/login")
    public String doGet(HttpServletRequest req)  {
       Object auth = req.getSession().getAttribute("authUser");
       if(auth == null){
           return "login";
          // return "/WEB-INF/view/page/login";
       }
        return "redirect:/user";
    }

    @PostMapping("/login")
    public String doPost(HttpServletRequest req)  {
       String login =req.getParameter("login");
       String password = req.getParameter("password");
        AuthUser authUser = security.getByLogin(login, password);
        if (authUser == null) {
            req.setAttribute("error", "login or password invalid");
            return "login";
           // return "/page/login";
        }else {
            log.info("user {} logged", authUser.getLogin());
            req.getSession().setAttribute("authUser", authUser);
               return "redirect:/user" ;
        }
    }
}
