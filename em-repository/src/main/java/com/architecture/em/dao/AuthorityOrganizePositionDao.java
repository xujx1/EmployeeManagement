package com.architecture.em.dao;

import com.architecture.em.entity.AuthorityOrganizePosition;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface AuthorityOrganizePositionDao {

    int delete(AuthorityOrganizePosition authorityOrganizePosition);

    int insert(AuthorityOrganizePosition authorityOrganizePosition);

    AuthorityOrganizePosition selectOne(AuthorityOrganizePosition authorityOrganizePosition);

    List<AuthorityOrganizePosition> select(AuthorityOrganizePosition authorityOrganizePosition);

    int update(AuthorityOrganizePosition authorityOrganizePosition);

    int count(AuthorityOrganizePosition authorityOrganizePosition);
}
