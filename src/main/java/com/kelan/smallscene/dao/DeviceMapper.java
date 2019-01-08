package com.kelan.smallscene.dao;

import com.kelan.smallscene.entity.Device;

public interface DeviceMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}