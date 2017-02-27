package com.architecture.em.dos.authorityOrganizePosition;

import com.alibaba.fastjson.JSON;
import com.architecture.em.dos.authority.AuthorityDo;
import com.architecture.em.dos.organize.OrganizeDo;
import com.architecture.em.dos.position.PositionDo;

import java.io.Serializable;

public class AuthorityOrganizePositionDo implements Serializable {

    private static final long serialVersionUID = 5682001546003294587L;

    private AuthorityDo authorityDo;

    private OrganizeDo organizeDo;

    private PositionDo positionDo;


    public AuthorityDo getAuthorityDo() {
        return authorityDo;
    }

    public void setAuthorityDo(AuthorityDo authorityDo) {
        this.authorityDo = authorityDo;
    }

    public OrganizeDo getOrganizeDo() {
        return organizeDo;
    }

    public void setOrganizeDo(OrganizeDo organizeDo) {
        this.organizeDo = organizeDo;
    }

    public PositionDo getPositionDo() {
        return positionDo;
    }

    public void setPositionDo(PositionDo positionDo) {
        this.positionDo = positionDo;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
