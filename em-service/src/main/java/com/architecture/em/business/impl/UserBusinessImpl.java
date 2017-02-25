package com.architecture.em.business.impl;

import com.architecture.em.business.UserBusiness;
import com.architecture.em.entity.User;
import com.architecture.em.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserBusinessImpl implements UserBusiness {

    @Inject
    private UserService userService;

    @Override
    public Integer insert(User user) {
        return userService.insert(user);
    }

    @Override
    public Integer update(User user) {
        return userService.update(user);
    }

    @Override
    public Integer delete(User user) {
        return userService.delete(user);
    }

    @Override
    public List<User> select(User user) {
        return userService.select(user);
    }
}
