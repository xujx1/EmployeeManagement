package com.architecture.em.dao.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.AuthorityDao;
import com.architecture.em.entity.Authority;
import com.architecture.em.mapper.AuthorityMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {

    @Inject
    private AuthorityMapper authorityMapper;

    @Override
    public int delete(Authority authority) {
        return authorityMapper.delete(authority);
    }

    @Override
    public int insert(Authority authority) {
        return authorityMapper.insert(authority);
    }

    @Override
    @ReadOnly
    public Authority selectOne(Authority authority) {
        return authorityMapper.selectOne(authority);
    }

    @Override
    @ReadOnly
    public List<Authority> select(Authority authority) {
        return authorityMapper.select(authority);
    }

    @Override
    public int update(Authority authority) {
        return authorityMapper.updateByPrimaryKey(authority);
    }

    @Override
    @ReadOnly
    public int count(Authority authority) {
        return authorityMapper.selectCount(authority);
    }
}
