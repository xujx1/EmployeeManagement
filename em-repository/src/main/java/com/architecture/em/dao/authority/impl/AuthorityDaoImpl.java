package com.architecture.em.dao.authority.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.authority.AuthorityDao;
import com.architecture.em.po.authority.AuthorityPo;
import com.architecture.em.mapper.authority.AuthorityMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {

    @Inject
    private AuthorityMapper authorityMapper;

    @Override
    public int delete(AuthorityPo authority) {
        return authorityMapper.delete(authority);
    }

    @Override
    public int insert(AuthorityPo authority) {
        return authorityMapper.insert(authority);
    }

    @Override
    @ReadOnly
    public AuthorityPo selectOne(AuthorityPo authority) {
        return authorityMapper.selectOne(authority);
    }

    @Override
    @ReadOnly
    public List<AuthorityPo> select(AuthorityPo authority) {
        return authorityMapper.select(authority);
    }

    @Override
    public int update(AuthorityPo authority) {
        return authorityMapper.updateByPrimaryKey(authority);
    }

    @Override
    @ReadOnly
    public int count(AuthorityPo authority) {
        return authorityMapper.selectCount(authority);
    }
}
