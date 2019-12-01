package com.github.Shevstrukk.web.filter.user.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/")
public class UserFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest rq = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null) {
            RequestDispatcher requestDispatcher = rq.getRequestDispatcher("/WEB-INF/view/login.jsp");
            requestDispatcher.forward(rq,resp);
            return;
        }
        filterChain.doFilter(rq, resp);
    }



}
