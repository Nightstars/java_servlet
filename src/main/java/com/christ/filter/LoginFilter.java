package com.christ.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*",initParams ={@WebInitParam(name="execludePage",value = "/test11/login.jsp,/test11/test11/LoginServlet")})
public class LoginFilter implements Filter {
    private String pagearr[];
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //判断用户是否登录，如果已登录，可以跳转到servlet或jsp
        //查看session是否有用户对象存 setAttribute("user",user);
        //否则跳转登录页面，完成，登录
        System.out.println("in loginFilter>>>>>");
        HttpServletRequest request=(HttpServletRequest)req;
        HttpSession session=request.getSession();
        Object user=session.getAttribute("user");
        if(isExcludePage(request.getRequestURI()))
        {
            chain.doFilter(req, resp);
        }else{
            if(user==null){
                //跳转登录
                HttpServletResponse response=(HttpServletResponse)resp;
                response.sendRedirect("/test11/login.jsp");
            }else{

            }
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        String pages=config.getInitParameter("execludePage");
        System.out.println("pages:    "+pages);
        this.pagearr=pages.split(",");
    }
    private boolean isExcludePage(String page){
        for (String pagename:pagearr){
            if(page.equals(pagename)) return true;
        }
        return  false;
    }

}
