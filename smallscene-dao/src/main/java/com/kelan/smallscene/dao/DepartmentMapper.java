package com.kelan.smallscene.dao;

import com.kelan.smallscene.entity.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}