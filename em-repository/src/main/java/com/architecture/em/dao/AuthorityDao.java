package com.architecture.em.dao;

import com.architecture.em.entity.Authority;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface AuthorityDao {

    int delete(Authority authority);

    int insert(Authority authority);

    Authority selectOne(Authority authority);

    List<Authority> select(Authority authority);

    int update(Authority authority);

    int count(Authority authority);
}
