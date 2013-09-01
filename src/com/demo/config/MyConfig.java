package com.demo.config;

import com.demo.utils.Constants;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Benson
 * Date: 13-4-18
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
public class MyConfig {
    private MyConfig() {
    }

    private static MyConfig myConfig = new MyConfig();

    private Map<String, ActionConfig> actionConfigs = new HashMap<String, ActionConfig>();


    public static MyConfig getMyConfig() {
        return myConfig;
    }

    public void addConfigByClass(Class clazz) {
        if (StringUtils.endsWith(clazz.getName(), Constants.ACTION_SUFFIX)) {
            ActionConfig actionConfig = ActionConfig.buildByClass(clazz);
            if (actionConfigs.get(actionConfig.getUrlName()) != null)
                throw new RuntimeException("duplicate action class found" + clazz.getName());
            actionConfigs.put(actionConfig.getUrlName().toLowerCase(), actionConfig);
        }
    }

    public ActionConfig getActionConfigByName(String name) {
        return actionConfigs.get(name);
    }



}

