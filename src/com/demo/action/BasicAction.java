package com.demo.action;

import com.demo.config.ActionConfig;
import com.demo.dao.ModelDao;
import com.demo.domain.BaseUser;
import com.demo.domain.Pagination;
import com.demo.utils.Constants;
import ognl.NullHandler;
import ognl.Ognl;
import ognl.OgnlRuntime;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicAction {

    private Pagination pagination = new Pagination();
    private ModelDao modelDao;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ActionConfig actionConfig;
    private String curMethodName;
    protected Logger logger = Logger. getLogger(BasicAction.class.getName());


    public final void dispatchUrl() {
        try {
            setAttributeToAction();
            Method curMethod = actionConfig.getMethodByName(curMethodName);
            String result = (String) curMethod.invoke(this);
            setAttributeToRequest();
            resultForward(result);
        } catch (Exception e) {
            logger.log(Level.WARNING, " =======error in dispatch ======= "+ e.getMessage(), e);
        }

    }

    private void resultForward(String result) throws ServletException, IOException {
        if (StringUtils.indexOf(result, Constants.ACTION_RESULT_SPLIT) > -1) {
            String[] results = StringUtils.split(result, Constants.ACTION_RESULT_SPLIT);

            if (results.length == 1) { //跳到默认模板
                request.setAttribute("contentPageJsp", results[0]);
                request.getRequestDispatcher(StringUtils.removeEnd(Constants.ACTION_RESULT_DEFAULT, Constants.ACTION_RESULT_SPLIT)).forward(request, response);
            } else {
                if (StringUtils.removeEnd(Constants.ACTION_RESULT_REDIRECT, Constants.ACTION_RESULT_SPLIT).equals(results[0])) {  //redirect
                    response.sendRedirect(results[1]);
                } else {  //跳到指定模板
                    request.setAttribute("contentPageJsp", results[1]);
                    request.getRequestDispatcher(results[0]).forward(request, response);
                }
            }
        } else {  //跳到JSP
            request.getRequestDispatcher(result).forward(request, response);
        }
    }

    private void setAttributeToRequest() throws InvocationTargetException, IllegalAccessException {
        for (String key : actionConfig.getGetMethod().keySet()) {
            Object value = actionConfig.getGetMethod().get(key).invoke(this);
            if (value != null) {
                request.setAttribute(key, actionConfig.getGetMethod().get(key).invoke(this));
            }
        }
    }


    private void setAttributeToAction() {
        try {
            //云平台一般都要把SecurityManager设置成NULL
            OgnlRuntime.setSecurityManager(null);
            //因为属性是NULL的时候我们要自动构建对应的类
            OgnlRuntime.setNullHandler(Object.class, new BasicAction.OnglNullHandler());
            Map<String, Object> parMap = request.getParameterMap();
            for (String name : parMap.keySet()) {
                Ognl.setValue(name, this, parMap.get(name));
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, " ========in setAttributeToAction ====== ", e);
        }

    }

    protected String getSessionOpenId() {
        if (request.getSession().getAttribute(Constants.SESSION_OPEN_ID) != null)
            return (String) request.getSession().getAttribute(Constants.SESSION_OPEN_ID);
        return null;
    }

    protected Integer getSessionUserId() {
        if (request.getSession().getAttribute(Constants.SESSION_USER_ID) != null)
            return (Integer) request.getSession().getAttribute(Constants.SESSION_USER_ID);
        return null;
    }



    public ModelDao getModelDao() {
        return modelDao;
    }

    public void setModelDao(ModelDao modelDao) {
        this.modelDao = modelDao;
    }

    protected void setUserToSession(BaseUser user) {
//        ActionContext.getContext().getSession().put(Constants.SESSION_USER_ID, user.getId());
//        ActionContext.getContext().getSession().put(Constants.SESSION_USER_NICKNANE, user.getNickName());
//        ActionContext.getContext().getSession().put(Constants.SESSION_OPEN_ID, user.getOpenId());
//        ActionContext.getContext().getSession().put(Constants.SESSION_FEATURE_URL, user.getFigureUrl());
//        ActionContext.getContext().getSession().put(Constants.SESSION_COMMUNITY_ID, this.getSessionCommunity());

    }


    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public ActionConfig getActionConfig() {
        return actionConfig;
    }

    public void setActionConfig(ActionConfig actionConfig) {
        this.actionConfig = actionConfig;
    }

    public String getCurMethodName() {
        return curMethodName;
    }

    public void setCurMethodName(String curMethodName) {
        this.curMethodName = curMethodName;
    }

    static class OnglNullHandler implements NullHandler {
        public OnglNullHandler() {
            super();
        }
        protected Logger logger = Logger. getLogger(OnglNullHandler.class.getName());
        public Object nullPropertyValue(Map context, Object target, Object property) {
            try {
                String propName = property.toString();
                Class clazz = OgnlRuntime.getPropertyDescriptor(target.getClass(), propName).getPropertyType();
                Object param = clazz.newInstance();//这里会新建实例
                logger.log(Level.WARNING,param.toString());
                Ognl.setValue(propName, context, target, param);//这里会是递归调用?
                return param;
            } catch (Exception e) {
                logger.log(Level.WARNING, " ===========in ongl=== ", e);
            }
            return null;
        }

        public Object nullMethodResult(Map context, Object target, String methodName, Object[] args) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
