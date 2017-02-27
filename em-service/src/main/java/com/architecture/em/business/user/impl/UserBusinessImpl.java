package com.architecture.em.business.user.impl;

import com.architecture.em.business.user.UserBusiness;
import com.architecture.em.dos.user.UserDo;
import com.architecture.em.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserBusinessImpl implements UserBusiness {

    @Inject
    private UserService userService;

    @Override
    @Transactional
    public Integer insert(UserDo user) {
        int val=0;
        if(null!=user){
            val=userService.insert(user);
        }
        return val;
    }

    @Override
    @Transactional
    public Integer update(UserDo user) {
        int val=0;
        if(null!=user){
            val=userService.update(user);
        }
        return val;
    }

    @Override
    @Transactional
    public Integer delete(UserDo user) {
        int val=0;
        if(null!=user){
            val=userService.delete(user);
        }
        return val;
    }

    @Override
    public List<UserDo> select(UserDo user) {
        List<UserDo> userDos=new ArrayList<>();
        if(null!=user){
            userDos=userService.select(user);
        }
        return userDos;
    }
}
