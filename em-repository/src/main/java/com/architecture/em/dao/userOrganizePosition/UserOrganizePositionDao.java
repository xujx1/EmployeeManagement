package com.architecture.em.dao.userOrganizePosition;

import com.architecture.em.po.userOrganizePosition.UserOrganizePositionPo;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface UserOrganizePositionDao {

    int delete(UserOrganizePositionPo userOrganizePosition);

    int insert(UserOrganizePositionPo userOrganizePosition);

    UserOrganizePositionPo selectOne(UserOrganizePositionPo userOrganizePosition);

    List<UserOrganizePositionPo> select(UserOrganizePositionPo userOrganizePosition);

    int update(UserOrganizePositionPo userOrganizePosition);

    int count(UserOrganizePositionPo userOrganizePosition);

}
