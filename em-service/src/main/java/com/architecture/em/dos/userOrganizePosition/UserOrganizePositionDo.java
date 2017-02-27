package com.architecture.em.dos.userOrganizePosition;

import com.alibaba.fastjson.JSON;
import com.architecture.em.dos.organize.OrganizeDo;
import com.architecture.em.dos.position.PositionDo;
import com.architecture.em.dos.user.UserDo;

import java.io.Serializable;


public class UserOrganizePositionDo implements Serializable {

    private static final long serialVersionUID = 7043750801581997551L;

    private UserDo userDo;

    private OrganizeDo organizeDo;

    private PositionDo positionDo;

    public UserDo getUserDo() {
        return userDo;
    }

    public void setUserDo(UserDo userDo) {
        this.userDo = userDo;
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
