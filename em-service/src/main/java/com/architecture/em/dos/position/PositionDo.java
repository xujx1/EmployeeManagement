package com.architecture.em.dos.position;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class PositionDo implements Serializable{

    private static final long serialVersionUID = 2856396640543609392L;

    private Integer id;
    private String positionName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
