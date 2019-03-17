package com.kelan.smallscene.dao;

import com.kelan.smallscene.bean.Role;

import java.util.List;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public interface RoleMapper {
  /**
   * <p>根据主键删除记录</p>
   * @method deleteByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:46
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
   * @date 2019/3/17 16:46
   * @param record 角色对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insert(Role record);

  /**
   * <p>根据主键添加记录</p>
   * @method insertSelective
   * @author jiaoguang
   * @date 2019/3/17 16:47
   * @param record 角色对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int insertSelective(Role record);

  /**
   * <p>根据主键查询数据</p>
   * @method selectByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:47
   * @param sid 主键
   * @return com.kelan.smallscene.bean.Role
   * @since V1.0.0
   * @version V1.0.0
   */
  Role selectByPrimaryKey(Long sid);

  /**
   * <p>根据主键更新数据</p>
   * @method updateByPrimaryKeySelective
   * @author jiaoguang
   * @date 2019/3/17 16:47
   * @param record 角色对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKeySelective(Role record);

  /**
   * <p>根据主键更新数据</p>
   * @method updateByPrimaryKey
   * @author jiaoguang
   * @date 2019/3/17 16:48
   * @param record 角色对象
   * @return int
   * @since V1.0.0
   * @version V1.0.0
   */
  int updateByPrimaryKey(Role record);

  /**
   * <p>根据角色UUID查询角色对象</p>
   * @method selectByRoleUUID
   * @author jiaoguang
   * @date 2019/3/17 17:14
   * @param roleUUIDList 角色唯一id集合
   * @return java.util.List<com.kelan.smallscene.bean.Role>
   * @since V1.0.0
   * @version V1.0.0
   */
  List<Role> selectByRoleUUIDList(List<String> roleUUIDList);
}