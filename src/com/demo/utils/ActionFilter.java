package com.demo.utils;

import com.demo.action.BasicAction;
import com.demo.config.ActionConfig;
import com.demo.config.MyConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ActionFilter implements Filter {


    public void destroy() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        String requestUrl = request.getServletPath();

        String actionUrl = this.getActionName(requestUrl);
        if (actionUrl != null) {
            this.execAction(actionUrl, request, response);
        } else {
            arg2.doFilter(arg0, arg1);
        }


    }


    private void execAction(String actionUrl, HttpServletRequest request, HttpServletResponse response) {
        String[] argUrls = StringUtils.split(actionUrl, "!");
        String actionName = argUrls[0];
        String methodName = argUrls[1];

        //根据名子得到Action
        MyConfig myConfig = MyConfig.getMyConfig();
        ActionConfig actionConfig = myConfig.getActionConfigByName(actionName);

        //从SPRING里拿到Action bean
        ServletContext servletContext = request.getSession().getServletContext();
        BasicAction actionClazz = (BasicAction) servletfindBean(servletContext, actionName.toLowerCase() + Constants.ACTION_SUFFIX);

        //初始化Action 的上下文
        actionClazz.setActionConfig(actionConfig);
        actionClazz.setCurMethodName(methodName);
        actionClazz.setRequest(request);
        actionClazz.setResponse(response);

        //调用Action dispatch方法
        actionClazz.dispatchUrl();
    }


    private static Object servletfindBean(ServletContext servletContext,
                                          String beanName) {
        ApplicationContext appctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return appctx.getBean(beanName);
    }

    private String getActionName(String url) {
        String[] argName = StringUtils.split(url, "/");
        if (argName.length < 1 || (argName.length == 1 && StringUtils.isBlank(argName[0]))) {
            return Constants.ACTION_DEFAULT + Constants.ACTION_METHOD_SPLIT + Constants.ACTION_METHOD_DEFAULT;
        } else {
            String name = argName[argName.length - 1];
            if (StringUtils.isBlank(argName[argName.length - 1]) && argName.length > 1) {
                name = argName[argName.length - 2];
            }
            if (name.indexOf(Constants.ACTION_METHOD_SPLIT) > 0) {
                return name.toLowerCase();
            } else if (name.indexOf(".") > 0) {
                return null;
            } else {
                return name.toLowerCase() + Constants.ACTION_METHOD_SPLIT + Constants.ACTION_METHOD_DEFAULT;
            }
        }
    }


}
