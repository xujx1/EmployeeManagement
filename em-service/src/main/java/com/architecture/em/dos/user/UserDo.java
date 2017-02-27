package com.architecture.em.dos.user;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;


public class UserDo implements Serializable {

    private static final long serialVersionUID = 8906038471435756136L;
    private Integer id;
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
