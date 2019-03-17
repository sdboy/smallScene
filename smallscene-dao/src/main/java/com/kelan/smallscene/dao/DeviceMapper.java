package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.Device;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public interface DeviceMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}