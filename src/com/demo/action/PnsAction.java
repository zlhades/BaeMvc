package com.demo.action;


import com.demo.utils.Constants;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.logging.Level;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PnsAction extends BasicAction {

    private String perID;
    private String mac;
    private String toking;


    public String index() throws Exception {
         logger.log(Level.WARNING, "==="+perID+"========="+mac+"================"+toking+"============");
        return Constants.ACTION_RESULT_DEFAULT+ "/jsp/demo/product/create.jsp";
    }

    public String getPerID() {
        return perID;
    }

    public void setPerID(String perID) {
        this.perID = perID;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getToking() {
        return toking;
    }

    public void setToking(String toking) {
        this.toking = toking;
    }
}
