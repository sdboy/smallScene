package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.UnitNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public interface UnitNodeMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(UnitNode record);

    int insertSelective(UnitNode record);

    UnitNode selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(UnitNode record);

    int updateByPrimaryKey(UnitNode record);
}