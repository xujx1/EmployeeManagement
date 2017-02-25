package com.architecture.em.dao.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.AuthorityOrganizePositionDao;
import com.architecture.em.entity.AuthorityOrganizePosition;
import com.architecture.em.mapper.AuthorityOrganizePositionMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class AuthorityOrganizePositionDaoImpl implements AuthorityOrganizePositionDao {

    @Inject
    private AuthorityOrganizePositionMapper authorityOrganizePositionMapper;

    @Override
    public int delete(AuthorityOrganizePosition authorityOrganizePosition) {
        return authorityOrganizePositionMapper.delete(authorityOrganizePosition);
    }

    @Override
    public int insert(AuthorityOrganizePosition authorityOrganizePosition) {
        return authorityOrganizePositionMapper.insert(authorityOrganizePosition);
    }

    @Override
    @ReadOnly
    public AuthorityOrganizePosition selectOne(AuthorityOrganizePosition authorityOrganizePosition) {
        return authorityOrganizePositionMapper.selectOne(authorityOrganizePosition);
    }

    @Override
    @ReadOnly
    public List<AuthorityOrganizePosition> select(AuthorityOrganizePosition authorityOrganizePosition) {
        return authorityOrganizePositionMapper.select(authorityOrganizePosition);
    }

    @Override
    public int update(AuthorityOrganizePosition authorityOrganizePosition) {
        return authorityOrganizePositionMapper.updateByPrimaryKey(authorityOrganizePosition);
    }

    @Override
    @ReadOnly
    public int count(AuthorityOrganizePosition authorityOrganizePosition) {
        return authorityOrganizePositionMapper.selectCount(authorityOrganizePosition);
    }
}
