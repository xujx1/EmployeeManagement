package com.architecture.em.po.userOrganizePosition;

import com.architecture.em.po.BasePo;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "user_organize_position")
//用户表
public class UserOrganizePositionPo extends BasePo {
    private static final long serialVersionUID = 5072204286895950793L;

    @Column(name = "user_id")
    private String userId;

    @Column(name="organize_id")
    private String organizeId;

    @Column(name="position_id")
    private String positionId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(String organizeId) {
        this.organizeId = organizeId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }
}
