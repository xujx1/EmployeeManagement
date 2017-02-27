package com.architecture.em.mapper.user;

import com.architecture.em.po.user.UserPo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<UserPo> {

}
