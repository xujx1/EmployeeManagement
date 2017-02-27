package com.architecture.em.dao.position;

import com.architecture.em.po.position.PositionPo;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface PositionDao {

    int delete(PositionPo position);

    int insert(PositionPo position);

    PositionPo selectOne(PositionPo position);

    List<PositionPo> select(PositionPo position);

    int update(PositionPo position);

    int count(PositionPo position);
}
