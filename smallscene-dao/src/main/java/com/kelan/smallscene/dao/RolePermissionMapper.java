package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}