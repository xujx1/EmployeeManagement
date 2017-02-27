package com.architecture.em.mapper.position;

import com.architecture.em.po.position.PositionPo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PositionMapper extends Mapper<PositionPo> {
}
