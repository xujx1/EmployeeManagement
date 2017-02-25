package com.architecture.em.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "authority_organize_position")
//组岗位权限表
public class AuthorityOrganizePosition extends BaseEntity {
    private static final long serialVersionUID = 11496591701102596L;

    @Column(name = "authority_id")
    private String authorityId;

    @Column(name="organize_id")
    private String organizeId;

    @Column(name="position_id")
    private String positionId;

    public String getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(String organizeId) {
        this.organizeId = organizeId;
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }
}
