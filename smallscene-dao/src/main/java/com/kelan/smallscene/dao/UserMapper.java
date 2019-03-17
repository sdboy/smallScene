package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.User;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public interface UserMapper {
  /**
   * <p>根据主键删除记录</p>
   * @method deleteByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:43
   * @param sid 主键
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int deleteByPrimaryKey(Long sid);

  /**
   * <p>添加记录</p>
   * @method insert
   * @author jiaoguang
   * @date 2019/3/17 16:43
   * @param record 用户对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insert(User record);

  /**
   * <p>添加记录</p>
   * @method insertSelective
   * @author jiaoguang
   * @date 2019/3/17 16:44
   * @param record 用户对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insertSelective(User record);

  /**
   * <p>根据主键查询记录</p>
   * @method selectByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:44
   * @param sid 主键
   * @return com.kelan.smallscene.bean.User
   * @since V1.0.0
   * @version V1.0.0
   */
  User selectByPrimaryKey(Long sid);

  /**
   * <p>根据主键更新记录</p>
   * @method updateByPrimaryKeySelective
   * @author jiaoguang
   * @date 2019/3/17 16:44
   * @param record 用户对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKeySelective(User record);

  /**
   * <p>根据主键更新记录</p>
   * @method updateByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:45
   * @param record 用户对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKey(User record);

  /**
   * <p>根据用户账号查询用户信息</p>
   * @method selectByUserAccount
   * @author jiaoguang
   * @date 2019/3/17 17:19
   * @param userAccount 用户账号
   * @return com.kelan.smallscene.bean.User
   * @since V1.0.0
   * @version V1.0.0
   */
  User selectByUserAccount(String userAccount);
}