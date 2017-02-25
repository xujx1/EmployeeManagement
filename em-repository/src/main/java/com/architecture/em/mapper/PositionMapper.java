package com.architecture.em.mapper;

import com.architecture.em.entity.Position;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PositionMapper extends Mapper<Position> {
}
