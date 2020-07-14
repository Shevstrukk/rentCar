package com.github.shevstrukk.web.controller;

import com.github.shevstrukk.service.SecurityService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;


@Controller
@RequestMapping
public class LogoutController {
    private final SecurityService service;

    public LogoutController(SecurityService service) {
        this.service = service;
    }

    @GetMapping("/logout")
    public String doGet(HttpSession session) {
        session.removeAttribute("authUser");
        session.invalidate();
        return "WEB-INF/view/page/login";
    }
}
