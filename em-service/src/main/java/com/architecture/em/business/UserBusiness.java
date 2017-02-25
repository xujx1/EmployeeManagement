package com.architecture.em.business;

import com.architecture.em.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/25.
 */
public interface UserBusiness {

    @Transactional
    Integer insert(User user);

    @Transactional
    Integer update(User user);

    @Transactional
    Integer delete(User user);

    List<User> select(User user);

}
