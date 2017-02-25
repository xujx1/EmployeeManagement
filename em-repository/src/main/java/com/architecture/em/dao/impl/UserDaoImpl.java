package com.architecture.em.dao.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.UserDao;
import com.architecture.em.entity.User;
import com.architecture.em.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Inject
    private UserMapper userMapper;

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    @ReadOnly
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }

    @Override
    @ReadOnly
    public List<User> select(User user) {
        return userMapper.select(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    @ReadOnly
    public int count(User user) {
        return userMapper.selectCount(user);
    }
}
