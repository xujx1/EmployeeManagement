package com.architecture.em.dos.organize;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class OrganizeDo implements Serializable {

    private static final long serialVersionUID = 7008120789672771831L;

    private Integer id;
    private String organizeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
