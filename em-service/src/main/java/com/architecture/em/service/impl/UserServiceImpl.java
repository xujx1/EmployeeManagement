package com.architecture.em.service.impl;

import com.architecture.em.annotation.NoLog;
import com.architecture.em.dao.UserDao;
import com.architecture.em.entity.User;
import com.architecture.em.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    @NoLog
    public User selectOne(User user) {
        return userDao.selectOne(user);
    }

    @Override
    @NoLog
    public List<User> select(User user) {
        return userDao.select(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    @NoLog
    public int count(User user) {
        return userDao.count(user);
    }
}
