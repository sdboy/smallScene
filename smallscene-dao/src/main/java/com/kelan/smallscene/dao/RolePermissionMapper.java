package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.RolePermission;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public interface RolePermissionMapper {
  /**
   * <p>根据主键删除数据</p>
   * @method deleteByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:48
   * @param sid 主键
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int deleteByPrimaryKey(Long sid);

  /**
   * <p>添加数据</p>
   * @method insert
   * @author jiaoguang
   * @date 2019/3/17 16:48
   * @param record 角色权限关联对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insert(RolePermission record);

  /**
   * <p>添加数据</p>
   * @method insertSelective
   * @author jiaoguang
   * @date 2019/3/17 16:49
   * @param record 角色权限关联对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insertSelective(RolePermission record);

  /**
   * <p>根据主键查询数据</p>
   * @method selectByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:49
   * @param sid 主键
   * @return com.kelan.smallscene.bean.RolePermission
   * @since V1.0.0
   * @version V1.0.0
   */
  RolePermission selectByPrimaryKey(Long sid);

  /**
   * <p>根据主键更新数据</p>
   * @method updateByPrimaryKeySelective
   * @author jiaoguang
   * @date 2019/3/17 16:49
   * @param record 角色权限关联对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKeySelective(RolePermission record);

  /**
   * <p>根据主键更新数据</p>
   * @method updateByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:49
   * @param record 角色权限关联对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKey(RolePermission record);
}