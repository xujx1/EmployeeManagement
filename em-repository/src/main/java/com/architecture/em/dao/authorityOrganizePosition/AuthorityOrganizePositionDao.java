package com.architecture.em.dao.authorityOrganizePosition;

import com.architecture.em.po.authorityOrganizePosition.AuthorityOrganizePositionPo;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface AuthorityOrganizePositionDao {

    int delete(AuthorityOrganizePositionPo authorityOrganizePosition);

    int insert(AuthorityOrganizePositionPo authorityOrganizePosition);

    AuthorityOrganizePositionPo selectOne(AuthorityOrganizePositionPo authorityOrganizePosition);

    List<AuthorityOrganizePositionPo> select(AuthorityOrganizePositionPo authorityOrganizePosition);

    int update(AuthorityOrganizePositionPo authorityOrganizePosition);

    int count(AuthorityOrganizePositionPo authorityOrganizePosition);
}
