package com.architecture.em.dao.userOrganizePosition.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.userOrganizePosition.UserOrganizePositionDao;
import com.architecture.em.po.userOrganizePosition.UserOrganizePositionPo;
import com.architecture.em.mapper.userOrganizePosition.UserOrganizePositionMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class UserOrganizePositionDaoImpl implements UserOrganizePositionDao {

    @Inject
    private UserOrganizePositionMapper userOrganizePositionMapper;

    @Override
    public int delete(UserOrganizePositionPo userOrganizePosition) {
        return userOrganizePositionMapper.delete(userOrganizePosition);
    }

    @Override
    public int insert(UserOrganizePositionPo userOrganizePosition) {
        return userOrganizePositionMapper.insert(userOrganizePosition);
    }

    @Override
    @ReadOnly
    public UserOrganizePositionPo selectOne(UserOrganizePositionPo userOrganizePosition) {
        return userOrganizePositionMapper.selectOne(userOrganizePosition);
    }

    @Override
    @ReadOnly
    public List<UserOrganizePositionPo> select(UserOrganizePositionPo userOrganizePosition) {
        return userOrganizePositionMapper.select(userOrganizePosition);
    }

    @Override
    public int update(UserOrganizePositionPo userOrganizePosition) {
        return userOrganizePositionMapper.updateByPrimaryKey(userOrganizePosition);
    }

    @Override
    @ReadOnly
    public int count(UserOrganizePositionPo userOrganizePosition) {
        return userOrganizePositionMapper.selectCount(userOrganizePosition);
    }
}
