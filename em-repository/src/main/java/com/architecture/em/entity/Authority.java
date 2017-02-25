package com.architecture.em.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "authority")
//权限表
public class Authority extends BaseEntity{
    private static final long serialVersionUID = -2535203943474828421L;

    @Column(name="authority_name")
    private String authorityName;

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
}
