package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//@WebServlet("/login")
@Controller
@RequestMapping("/login")
public class LoginServlet  {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    @Autowired
    DefaultUserService defaultUserService;
    @GetMapping("/login")
    public String doGet(HttpServletRequest rq) {
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null)
            return "login";

        return "registration";

    }
    @PostMapping("/login")
    public String doPost(HttpServletRequest req)  {

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        AuthUser user = defaultUserService.login(login, password);

        if (user == null) {
            req.setAttribute("error", "login or password invalid");
            return "login";
//            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
//            return;
        }
        log.info("user {} logged", user.getLogin());

        if (user.getRole().equals("admin")){
            req.getSession().setAttribute("authUser", user);
            return "admin_menu";
//            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, resp);
//            return;
        }else if(user.getRole().equals("user")
                & user.getPerson() == null){
            req.getSession().setAttribute("authUser", user);
            return "user_menu";
//            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, resp);
//            return;
        }else if(user.getRole().equals("user") & user.getPerson()!=null ){
            Person person =user.getPerson();
            HttpSession session=req.getSession();
            session.setAttribute("authUser", user);
            return "order/orderUser";
//            req.getRequestDispatcher("/WEB-INF/view/order/ordersUser.jsp").forward(req, resp);
        }
        return null;
    }
}
