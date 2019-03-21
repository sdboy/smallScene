package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.Channel;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public interface ChannelMapper {
  int deleteByPrimaryKey(Long sid);

  int insert(Channel record);

  int insertSelective(Channel record);

  Channel selectByPrimaryKey(Long sid);

  int updateByPrimaryKeySelective(Channel record);

  int updateByPrimaryKey(Channel record);
}