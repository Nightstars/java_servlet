package com.christ.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/*"})
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("in before   2  $$$$$$$$>>>>>>%%%");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("in after    2   $$$$$$$$>>>>>>%%%");
    }

    @Override
    public void destroy() {

    }
}
