package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}