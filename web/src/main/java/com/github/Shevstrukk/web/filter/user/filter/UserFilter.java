package com.github.Shevstrukk.web.filter.user.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/")
public class UserFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/WEB-INF/view/login.jsp");
        requestDispatcher.forward(servletRequest, servletResponse);
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
