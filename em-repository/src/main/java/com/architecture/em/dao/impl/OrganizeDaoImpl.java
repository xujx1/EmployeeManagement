package com.architecture.em.dao.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.OrganizeDao;
import com.architecture.em.entity.Organize;
import com.architecture.em.mapper.OrganizeMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class OrganizeDaoImpl implements OrganizeDao{

    @Inject
    private OrganizeMapper organizeMapper;

    @Override
    public int delete(Organize organize) {
        return organizeMapper.delete(organize);
    }

    @Override
    public int insert(Organize organize) {
        return organizeMapper.insert(organize);
    }

    @Override
    @ReadOnly
    public Organize selectOne(Organize organize) {
        return organizeMapper.selectOne(organize);
    }

    @Override
    @ReadOnly
    public List<Organize> select(Organize organize) {
        return organizeMapper.select(organize);
    }

    @Override
    public int update(Organize organize) {
        return organizeMapper.updateByPrimaryKey(organize);
    }

    @Override
    @ReadOnly
    public int count(Organize organize) {
        return organizeMapper.selectCount(organize);
    }
}
