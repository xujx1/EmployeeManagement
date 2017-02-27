package com.architecture.em.po.authority;

import com.architecture.em.po.BasePo;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "authority")
//权限表
public class AuthorityPo extends BasePo {
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
