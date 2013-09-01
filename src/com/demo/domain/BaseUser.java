package com.demo.domain;

import javax.persistence.Entity;
import java.util.Calendar;

@Entity
public class BaseUser
        extends AbstractPersistence
{

    private String openId;
    private Calendar createDate = Calendar.getInstance();
    private String regTime;
    private String nickName;
    private String figureUrl;



    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFigureUrl() {
        return figureUrl;
    }

    public void setFigureUrl(String featureUrl) {
        this.figureUrl = featureUrl;
    }


}
