package com.architecture.em.dao.authority;

import com.architecture.em.po.authority.AuthorityPo;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface AuthorityDao {

    int delete(AuthorityPo authority);

    int insert(AuthorityPo authority);

    AuthorityPo selectOne(AuthorityPo authority);

    List<AuthorityPo> select(AuthorityPo authority);

    int update(AuthorityPo authority);

    int count(AuthorityPo authority);
}
