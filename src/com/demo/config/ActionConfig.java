package com.demo.config;

import com.demo.utils.Constants;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class ActionConfig {
    private String fullName;
    private Class clazz;
    private String urlName;
    private Map<String, Method> methodMap = new HashMap<String, Method>();
    private Map<String, Method> getMethod = new HashMap<String, Method>();


    public ActionConfig() {

    }


    public static ActionConfig buildByClass(Class clazz) {
        ActionConfig actionConfig = new ActionConfig();
        actionConfig.initWithClass(clazz);
        return actionConfig;
    }

    private  void initWithClass(Class clazz) {

        this.clazz = clazz;
        this.fullName =clazz.getName();
        String[] arName = StringUtils.split(clazz.getName(), ".");
        String urlName = StringUtils.removeEndIgnoreCase(arName[arName.length - 1], Constants.ACTION_SUFFIX);
        this.urlName =urlName;

        Method[] methods = clazz.getDeclaredMethods();
        //缓存方法
        for (Method method : methods) {
            String methodName = method.getName();
            if (StringUtils.startsWith(methodName, "get")) {//缓存数据方法
                if (!StringUtils.endsWith(methodName,"Dao") )  {
                    String proNameTmp = StringUtils.removeStart(methodName,"get" );
                    String proName  = proNameTmp.substring(0,1).toLowerCase()+proNameTmp.substring(1);
                    this.getMethod.put(proName, method);
                }
            } else { //缓存Action方法
                this.methodMap.put(method.getName().toLowerCase(), method);
            }
        }
    }

    public Map<String, Method> getGetMethod() {
        return getMethod;
    }


    public Method getMethodByName(String name) {
        return this.methodMap.get(name);
    }

    public String getFullName() {
        return fullName;
    }


    public Class getClazz() {
        return clazz;
    }


    public String getUrlName() {
        return urlName;
    }


}
