package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.UserRole;

import java.util.List;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public interface UserRoleMapper {
  /**
   * <p>根据主键删除记录</p>
   * @method deleteByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:28
   * @param sid 主键
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int deleteByPrimaryKey(Long sid);

  /**
   * <p>添加一条数据</p>
   * @method insert
   * @author jiaoguang
   * @date 2019/3/17 16:31
   * @param record 用户角色关联对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insert(UserRole record);

  /**
   * <p>添加一条数据</p>
   * @method insertSelective
   * @author jiaoguang
   * @date 2019/3/17 16:32
   * @param record 用户角色关联对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insertSelective(UserRole record);

  /**
   * <p>根据主键查询记录</p>
   * @method selectByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:34
   * @param sid 主键
   * @return com.kelan.smallscene.bean.UserRole
   * @since V1.0.0
   * @version V1.0.0
   */
  UserRole selectByPrimaryKey(Long sid);

  /**
   * <p>根据主键更新记录</p>
   * @method updateByPrimaryKeySelective
   * @author jiaoguang
   * @date 2019/3/17 16:35
   * @param record 用户角色关联对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKeySelective(UserRole record);

  /**
   * <p>根据主键更新记录</p>
   * @method updateByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:35
   * @param record 用户角色关联对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKey(UserRole record);

  /**
   * <p>根据用户唯一id，查询用户具有的角色的唯一id</p>
   * @method selectByUserUUID
   * @author jiaoguang
   * @date 2019/3/17 17:09
   * @param userUUID 用户唯一id
   * @return com.kelan.smallscene.bean.UserRole
   * @since V1.0.0
   * @version V1.0.0
   */
  List<String> selectByUserUUID(String userUUID);
}