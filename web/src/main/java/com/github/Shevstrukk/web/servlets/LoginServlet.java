package com.github.Shevstrukk.web.servlets;

import com.github.Shevstrukk.dao.entity.AuthUserEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.service.DefaultUserService;
import com.github.Shevstrukk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Controller
@RequestMapping
public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    @Autowired
    DefaultUserService defaultUserService;
    @GetMapping("/login")
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null) {
            RequestDispatcher requestDispatcher = rq.getRequestDispatcher("/WEB-INF/view/login.jsp");
            try {
                requestDispatcher.forward(rq,rs);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        AuthUser user = defaultUserService.login(login, password);

        if (user == null) {
            req.setAttribute("error", "login or password invalid");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
            return;
        }
        log.info("user {} logged", user.getLogin());
        // req.getSession().setAttribute("authUser", user);

        if (user.getRole().equals("admin")){
            req.getSession().setAttribute("authUser", user);
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, resp);
            return;
        }else if(user.getRole().equals("user")
                & user.getPerson() == null){
            req.getSession().setAttribute("authUser", user);
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, resp);
            return;
        }else if(user.getRole().equals("user") & user.getPerson()!=null ){
            Person person =user.getPerson();
            HttpSession session=req.getSession();
            session.setAttribute("authUser", user);
            req.getRequestDispatcher("/WEB-INF/view/order/ordersUser.jsp").forward(req, resp);
        }
    }
}
