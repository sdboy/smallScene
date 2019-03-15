package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}