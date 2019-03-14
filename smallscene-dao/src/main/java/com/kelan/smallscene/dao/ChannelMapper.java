package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.Channel;
import org.apache.ibatis.annotations.Mapper;

public interface ChannelMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}