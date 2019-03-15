package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}