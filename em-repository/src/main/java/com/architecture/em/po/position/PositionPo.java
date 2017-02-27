package com.architecture.em.po.position;

import com.architecture.em.po.BasePo;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "position")
//职位表
public class PositionPo extends BasePo {
    private static final long serialVersionUID = 194511401277156289L;

    @Column(name = "position_name")
    private String positionName;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
