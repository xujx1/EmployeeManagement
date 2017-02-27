package com.architecture.em.dao.organize.impl;

import com.architecture.em.annotation.ReadOnly;
import com.architecture.em.dao.organize.OrganizeDao;
import com.architecture.em.po.organize.OrganizePo;
import com.architecture.em.mapper.organize.OrganizeMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class OrganizeDaoImpl implements OrganizeDao{

    @Inject
    private OrganizeMapper organizeMapper;

    @Override
    public int delete(OrganizePo organize) {
        return organizeMapper.delete(organize);
    }

    @Override
    public int insert(OrganizePo organize) {
        return organizeMapper.insert(organize);
    }

    @Override
    @ReadOnly
    public OrganizePo selectOne(OrganizePo organize) {
        return organizeMapper.selectOne(organize);
    }

    @Override
    @ReadOnly
    public List<OrganizePo> select(OrganizePo organize) {
        return organizeMapper.select(organize);
    }

    @Override
    public int update(OrganizePo organize) {
        return organizeMapper.updateByPrimaryKey(organize);
    }

    @Override
    @ReadOnly
    public int count(OrganizePo organize) {
        return organizeMapper.selectCount(organize);
    }
}
