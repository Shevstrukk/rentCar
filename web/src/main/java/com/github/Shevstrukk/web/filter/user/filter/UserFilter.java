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
     /*   Object user;
        if (null == (user = rq.getSession().getAttribute("admin") )) {
            RequestDispatcher requestDispatcher = rq.getRequestDispatcher("/WEB-INF/view/login.jsp");
            requestDispatcher.forward(rq,resp);
            return;
        }else if ( (user=rq.getSession().getAttribute("user")) == null){

        }*/

        RequestDispatcher requestDispatcher = rq.getRequestDispatcher("/WEB-INF/view/login.jsp");
        requestDispatcher.forward(rq,resp);
        filterChain.doFilter(rq, resp);

    }
}
