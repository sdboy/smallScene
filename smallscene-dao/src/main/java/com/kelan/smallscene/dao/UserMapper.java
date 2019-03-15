package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}