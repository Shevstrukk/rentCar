package com.github.shevstrukk.web.servlet;

import com.github.shevstrukk.web.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping
public class LogoutServlet  {
    @GetMapping("/logout")
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        rq.getSession().removeAttribute("authUser");
        rq.getSession().invalidate();
        WebUtils.forward("login", rq, rs);
    }
}
