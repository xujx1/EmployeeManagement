package com.architecture.em.dao;

import com.architecture.em.entity.Position;

import java.util.List;

/**
 * Created by xujinxin on 2017/2/24.
 */
public interface PositionDao {

    int delete(Position position);

    int insert(Position position);

    Position selectOne(Position position);

    List<Position> select(Position position);

    int update(Position position);

    int count(Position position);
}
