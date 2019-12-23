package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;

import com.github.Shevstrukk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



//@WebServlet("/login")
@Controller
@RequestMapping
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public String doGet(HttpServletRequest rq) {
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null){
            return "login";}

        return "registration";
    }

        @PostMapping("/login")
        public String doPost(HttpServletRequest rq, Model model)  {
            final String login = rq.getParameter("login");
            final String password = rq.getParameter("password");
            AuthUser user = userService.login(login, password);
            if (user == null) {
                model.addAttribute("error", "login or password invalid");
                return "login";
            }
            log.info("user {} logged", user.getLogin());

            if (user.getRole().equals("admin")){
                rq.getSession().setAttribute("authUser", user);
                return "admin_menu";

            }else if(user.getRole().equals("user")
                    & user.getPerson() == null){
                rq.getSession().setAttribute("authUser", user);
                return "user_menu";

            }else
                if(user.getRole().equals("user") & user.getPerson()!=null ){
                Person person =user.getPerson();
                HttpSession session=rq.getSession();
                session.setAttribute("authUser", user);
                return "/order/ordersUser";
            }
            return null;
        }


    }
