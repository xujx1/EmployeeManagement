package com.architecture.em.dos.authority;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class AuthorityDo implements Serializable {

    private static final long serialVersionUID = -6643490810442380978L;

    private Integer id;
    private String authorityName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
