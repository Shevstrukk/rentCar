package com.github.shevstrukk.web.filter;

import com.github.shevstrukk.web.WebUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/user")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest)request;
        Object auth = request1.getSession().getAttribute("authUser");
        if (auth==null){
            WebUtils.forword("login",request1, (HttpServletResponse)response);
        }
        chain.doFilter(request1, response);
    }

    @Override
    public void destroy() {

    }
}
