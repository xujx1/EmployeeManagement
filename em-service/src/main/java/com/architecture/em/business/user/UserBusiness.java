package com.architecture.em.business.user;

import com.architecture.em.dos.user.UserDo;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/25.
 */
public interface UserBusiness {

    Integer insert(UserDo user);

    Integer update(UserDo user);

    Integer delete(UserDo user);

    List<UserDo> select(UserDo user);

}
