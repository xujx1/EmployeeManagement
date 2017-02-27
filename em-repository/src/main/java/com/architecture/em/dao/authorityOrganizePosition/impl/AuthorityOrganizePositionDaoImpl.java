package com.architecture.em.dao.authorityOrganizePosition.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.authorityOrganizePosition.AuthorityOrganizePositionDao;
import com.architecture.em.po.authorityOrganizePosition.AuthorityOrganizePositionPo;
import com.architecture.em.mapper.authorityOrganizePosition.AuthorityOrganizePositionMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class AuthorityOrganizePositionDaoImpl implements AuthorityOrganizePositionDao {

    @Inject
    private AuthorityOrganizePositionMapper authorityOrganizePositionMapper;

    @Override
    public int delete(AuthorityOrganizePositionPo authorityOrganizePosition) {
        return authorityOrganizePositionMapper.delete(authorityOrganizePosition);
    }

    @Override
    public int insert(AuthorityOrganizePositionPo authorityOrganizePosition) {
        return authorityOrganizePositionMapper.insert(authorityOrganizePosition);
    }

    @Override
    @ReadOnly
    public AuthorityOrganizePositionPo selectOne(AuthorityOrganizePositionPo authorityOrganizePosition) {
        return authorityOrganizePositionMapper.selectOne(authorityOrganizePosition);
    }

    @Override
    @ReadOnly
    public List<AuthorityOrganizePositionPo> select(AuthorityOrganizePositionPo authorityOrganizePosition) {
        return authorityOrganizePositionMapper.select(authorityOrganizePosition);
    }

    @Override
    public int update(AuthorityOrganizePositionPo authorityOrganizePosition) {
        return authorityOrganizePositionMapper.updateByPrimaryKey(authorityOrganizePosition);
    }

    @Override
    @ReadOnly
    public int count(AuthorityOrganizePositionPo authorityOrganizePosition) {
        return authorityOrganizePositionMapper.selectCount(authorityOrganizePosition);
    }
}
