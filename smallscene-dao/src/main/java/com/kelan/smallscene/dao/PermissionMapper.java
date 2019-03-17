package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.Permission;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public interface PermissionMapper {
  /**
   * <p>根据主键删除记录</p>
   * @method deleteByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:52
   * @param sid 主键
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int deleteByPrimaryKey(Long sid);

  /**
   * <p>根据主键添加记录</p>
   * @method insert
   * @author jiaoguang
   * @date 2019/3/17 16:52
   * @param record 权限对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insert(Permission record);

  /**
   * <p>根据主键添加记录</p>
   * @method insertSelective
   * @author jiaoguang
   * @date 2019/3/17 16:52
   * @param record 权限对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insertSelective(Permission record);

  /**
   * <p>根据主键查询数据</p>
   * @method selectByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:52
   * @param sid 主键
   * @return com.kelan.smallscene.bean.Permission
   * @since V1.0.0
   * @version V1.0.0
   */
  Permission selectByPrimaryKey(Long sid);

  /**
   * <p>根据主键更新数据</p>
   * @method updateByPrimaryKeySelective
   * @author jiaoguang
   * @date 2019/3/17 16:53
   * @param record 权限对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKeySelective(Permission record);

  /**
   * <p>根据主键更新数据</p>
   * @method updateByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:53
   * @param record 权限对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKey(Permission record);
}