package com.architecture.em.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "user")
//用户表
public class User extends BaseEntity{
    private static final long serialVersionUID = 8836697505698306451L;

    @Column(name = "user_name")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
