package com.architecture.em.dao.organize;

import com.architecture.em.po.organize.OrganizePo;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface OrganizeDao {

    int delete(OrganizePo organize);

    int insert(OrganizePo organize);

    OrganizePo selectOne(OrganizePo organize);

    List<OrganizePo> select(OrganizePo organize);

    int update(OrganizePo organize);

    int count(OrganizePo organize);
}
