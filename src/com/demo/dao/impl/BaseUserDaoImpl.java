package com.demo.dao.impl;

import com.demo.dao.BaseUserDao;
import com.demo.domain.BaseUser;
import org.springframework.stereotype.Repository;

@Repository("baseUserDao")
public class BaseUserDaoImpl extends ModelDaoImpl<BaseUser> implements BaseUserDao {


    public BaseUser findByOpenId(String openId) {
        return findFist("From BaseUser u where u.openId=?",openId);
    }

    public BaseUser findByNickName(String nickName) {
        return findFist("From BaseUser u where u.nickName=?",nickName);
    }
}
