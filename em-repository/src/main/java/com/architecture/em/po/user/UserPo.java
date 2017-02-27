package com.architecture.em.po.user;

import com.architecture.em.po.BasePo;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "user")
//用户表
public class UserPo extends BasePo {
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
