package com.architecture.em.dao;

import com.architecture.em.entity.UserOrganizePosition;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface UserOrganizePositionDao {

    int delete(UserOrganizePosition userOrganizePosition);

    int insert(UserOrganizePosition userOrganizePosition);

    UserOrganizePosition selectOne(UserOrganizePosition userOrganizePosition);

    List<UserOrganizePosition> select(UserOrganizePosition userOrganizePosition);

    int update(UserOrganizePosition userOrganizePosition);

    int count(UserOrganizePosition userOrganizePosition);

}
