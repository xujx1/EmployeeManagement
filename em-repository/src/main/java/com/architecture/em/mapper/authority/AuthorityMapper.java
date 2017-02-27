package com.architecture.em.mapper.authority;

import com.architecture.em.po.authority.AuthorityPo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AuthorityMapper extends Mapper<AuthorityPo> {
}
