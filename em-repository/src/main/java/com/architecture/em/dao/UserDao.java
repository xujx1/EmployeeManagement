package com.architecture.em.dao;

import com.architecture.em.entity.User;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/23.
 */
public interface UserDao {

    int delete(User user);

    int insert(User user);

    User selectOne(User user);

    List<User> select(User user);

    int update(User user);

    int count(User user);
}
