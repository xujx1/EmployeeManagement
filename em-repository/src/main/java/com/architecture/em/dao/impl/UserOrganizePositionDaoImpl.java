package com.architecture.em.dao.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.UserOrganizePositionDao;
import com.architecture.em.entity.UserOrganizePosition;
import com.architecture.em.mapper.UserOrganizePositionMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class UserOrganizePositionDaoImpl implements UserOrganizePositionDao {

    @Inject
    private UserOrganizePositionMapper userOrganizePositionMapper;

    @Override
    public int delete(UserOrganizePosition userOrganizePosition) {
        return userOrganizePositionMapper.delete(userOrganizePosition);
    }

    @Override
    public int insert(UserOrganizePosition userOrganizePosition) {
        return userOrganizePositionMapper.insert(userOrganizePosition);
    }

    @Override
    @ReadOnly
    public UserOrganizePosition selectOne(UserOrganizePosition userOrganizePosition) {
        return userOrganizePositionMapper.selectOne(userOrganizePosition);
    }

    @Override
    @ReadOnly
    public List<UserOrganizePosition> select(UserOrganizePosition userOrganizePosition) {
        return userOrganizePositionMapper.select(userOrganizePosition);
    }

    @Override
    public int update(UserOrganizePosition userOrganizePosition) {
        return userOrganizePositionMapper.updateByPrimaryKey(userOrganizePosition);
    }

    @Override
    @ReadOnly
    public int count(UserOrganizePosition userOrganizePosition) {
        return userOrganizePositionMapper.selectCount(userOrganizePosition);
    }
}
