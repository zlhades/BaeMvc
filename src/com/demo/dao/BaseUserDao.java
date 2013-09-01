package com.demo.dao;

import com.demo.domain.BaseUser;

public interface BaseUserDao extends ModelDao<BaseUser>{

    public BaseUser findByOpenId(String openId);
    public BaseUser findByNickName(String nickName);


}
