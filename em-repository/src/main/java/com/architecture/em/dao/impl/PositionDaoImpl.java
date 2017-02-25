package com.architecture.em.dao.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.PositionDao;
import com.architecture.em.entity.Position;
import com.architecture.em.mapper.PositionMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao{

    @Inject
    private PositionMapper positionMapper;

    @Override
    public int delete(Position position) {
        return positionMapper.delete(position);
    }

    @Override
    public int insert(Position position) {
        return positionMapper.insert(position);
    }

    @Override
    @ReadOnly
    public Position selectOne(Position position) {
        return positionMapper.selectOne(position);
    }

    @Override
    @ReadOnly
    public List<Position> select(Position position) {
        return positionMapper.select(position);
    }

    @Override
    public int update(Position position) {
        return positionMapper.updateByPrimaryKey(position);
    }

    @Override
    @ReadOnly
    public int count(Position position) {
        return positionMapper.selectCount(position);
    }
}
