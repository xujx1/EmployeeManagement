package com.architecture.em.dao;

import com.architecture.em.entity.Organize;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface OrganizeDao {

    int delete(Organize organize);

    int insert(Organize organize);

    Organize selectOne(Organize organize);

    List<Organize> select(Organize organize);

    int update(Organize organize);

    int count(Organize organize);
}
