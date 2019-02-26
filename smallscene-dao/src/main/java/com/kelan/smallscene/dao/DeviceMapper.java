package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.Device;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}