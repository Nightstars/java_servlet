package com.christ.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("in before……");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=ut-8");
        chain.doFilter(req, resp);
        System.out.println("in after……");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
