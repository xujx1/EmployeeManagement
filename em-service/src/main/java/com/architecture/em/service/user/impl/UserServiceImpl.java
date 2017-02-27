package com.architecture.em.service.user.impl;

import com.architecture.em.annotation.NoLog;
import com.architecture.em.dao.user.UserDao;
import com.architecture.em.dos.user.UserDo;
import com.architecture.em.po.user.UserPo;
import com.architecture.em.service.user.UserService;
import com.architecture.em.utils.beans.BeanCopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public int delete(UserDo user) {
        return userDao.delete(BeanCopyUtil.copy(user, UserPo.class));
    }

    @Override
    public int insert(UserDo user) {
        return userDao.insert(BeanCopyUtil.copy(user, UserPo.class));
    }

    @Override
    @NoLog
    public UserDo selectOne(UserDo user) {
        UserPo userPo=BeanCopyUtil.copy(user, UserPo.class);
        userPo= userDao.selectOne(userPo);
        UserDo userDo=new UserDo();
        if(null!=userPo){
            userDo=BeanCopyUtil.copy(userPo,UserDo.class);
        }
        return userDo;
    }

    @Override
    @NoLog
    public List<UserDo> select(UserDo user) {
        UserPo userPo=BeanCopyUtil.copy(user, UserPo.class);
        List<UserPo> userPos=userDao.select(userPo);
        List<UserDo> userDos=new ArrayList<>();
        if(!CollectionUtils.isEmpty(userPos)){
            userDos=BeanCopyUtil.copyList(userPos,UserPo.class,UserDo.class);
        }
        return userDos;
    }

    @Override
    public int update(UserDo user) {
        return userDao.update(BeanCopyUtil.copy(user, UserPo.class));
    }

    @Override
    @NoLog
    public int count(UserDo user) {
        return userDao.count(BeanCopyUtil.copy(user, UserPo.class));
    }
}
