package com.architecture.em.dao.user;

import com.architecture.em.po.user.UserPo;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/23.
 */
public interface UserDao {

    int delete(UserPo user);

    int insert(UserPo user);

    UserPo selectOne(UserPo user);

    List<UserPo> select(UserPo user);

    int update(UserPo user);

    int count(UserPo user);
}
