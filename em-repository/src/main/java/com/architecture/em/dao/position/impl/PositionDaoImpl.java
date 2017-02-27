package com.architecture.em.dao.position.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.position.PositionDao;
import com.architecture.em.po.position.PositionPo;
import com.architecture.em.mapper.position.PositionMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao{

    @Inject
    private PositionMapper positionMapper;

    @Override
    public int delete(PositionPo position) {
        return positionMapper.delete(position);
    }

    @Override
    public int insert(PositionPo position) {
        return positionMapper.insert(position);
    }

    @Override
    @ReadOnly
    public PositionPo selectOne(PositionPo position) {
        return positionMapper.selectOne(position);
    }

    @Override
    @ReadOnly
    public List<PositionPo> select(PositionPo position) {
        return positionMapper.select(position);
    }

    @Override
    public int update(PositionPo position) {
        return positionMapper.updateByPrimaryKey(position);
    }

    @Override
    @ReadOnly
    public int count(PositionPo position) {
        return positionMapper.selectCount(position);
    }
}
