package com.demo.config;


import com.demo.utils.Constants;
import com.demo.utils.Utils;
import ognl.OgnlException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import java.util.Set;


public class LifecycleInit extends ContextLoaderListener {

    public void contextInitialized(ServletContextEvent event) {
        init();
    }

    public void init() {
        Set<Class<?>> classes = Utils.getClasses(Constants.ACTION_PACKAGE);
        for (Class c : classes) {
            MyConfig.getMyConfig().addConfigByClass(c);
        }
    }


    public static void main(String args[]) throws OgnlException {
        String s = "1test";
        String[] arg = StringUtils.split(s, ":");

            System.out.println(StringUtils.indexOf(s,":")+"============" + arg.length);






    }


}

