package com.github.Shevstrukk.web.servlets.phone;

import com.github.Shevstrukk.dao.entity.AuthUser;
import com.github.Shevstrukk.dao.entity.Phone;
import com.github.Shevstrukk.service.phoneservice.DefaultPhoneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPhone")
public class AddPhoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String line = String.valueOf(req.getParameter("phone"));
        AuthUser user = (AuthUser) req.getSession().getAttribute("authUser");
        Integer userId = user.getId();
        Phone phone = new Phone(null,line,null, userId);
        DefaultPhoneService.getInstance().savePhone(phone);

    }
}
