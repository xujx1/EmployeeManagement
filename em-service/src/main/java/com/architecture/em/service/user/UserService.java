package com.architecture.em.service.user;

import com.architecture.em.dos.user.UserDo;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/23.
 */
public interface UserService {

    int delete(UserDo user);

    int insert(UserDo user);

    UserDo selectOne(UserDo user);

    List<UserDo> select(UserDo user);

    int update(UserDo user);

    int count(UserDo user);

}
