package com.demo.utils;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainFilter implements Filter {


    private static List<String> NEED_LOGIN = new ArrayList<String>();


    static {
        NEED_LOGIN.add("/myfirstPage.html");


    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession();
        request.setCharacterEncoding( "UTF-8");
        System.out.println("---------------" + request.getServletPath() + "-----------------");
        String requestUrl = request.getServletPath();


        for (String url : NEED_LOGIN) {
            if (StringUtils.startsWithIgnoreCase(requestUrl, url) && session.getAttribute(Constants.SESSION_USER_ID) == null) {
                response.sendRedirect("logon.html?reDirectUrl="+request.getServletPath()+ "?" +  java.net.URLEncoder.encode(Utils.getEmptyString(request.getQueryString()),"utf-8"));
                return;
            }
        }

        arg2.doFilter(arg0, arg1);
    }



}
