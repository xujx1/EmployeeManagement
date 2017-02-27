package com.architecture.em.dao.user.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.user.UserDao;
import com.architecture.em.po.user.UserPo;
import com.architecture.em.mapper.user.UserMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Inject
    private UserMapper userMapper;

    @Override
    public int delete(UserPo user) {
        return userMapper.delete(user);
    }

    @Override
    public int insert(UserPo user) {
        return userMapper.insert(user);
    }

    @Override
    @ReadOnly
    public UserPo selectOne(UserPo user) {
        return userMapper.selectOne(user);
    }

    @Override
    @ReadOnly
    public List<UserPo> select(UserPo user) {
        return userMapper.select(user);
    }

    @Override
    public int update(UserPo user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    @ReadOnly
    public int count(UserPo user) {
        return userMapper.selectCount(user);
    }
}
