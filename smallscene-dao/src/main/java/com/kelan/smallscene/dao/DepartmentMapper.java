package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public interface DepartmentMapper {
  int deleteByPrimaryKey(Long sid);

  int insert(Department record);

  int insertSelective(Department record);

  Department selectByPrimaryKey(Long sid);

  int updateByPrimaryKeySelective(Department record);

  int updateByPrimaryKey(Department record);
}