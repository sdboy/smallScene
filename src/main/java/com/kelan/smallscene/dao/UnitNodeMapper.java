package com.kelan.smallscene.dao;

import com.kelan.smallscene.entity.UnitNode;

public interface UnitNodeMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(UnitNode record);

    int insertSelective(UnitNode record);

    UnitNode selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(UnitNode record);

    int updateByPrimaryKey(UnitNode record);
}