package com.kelan.smallscene.service.impl;

import com.kelan.smallscene.bean.Role;
import com.kelan.smallscene.bean.User;
import com.kelan.smallscene.bean.UserDetailsImpl;
import com.kelan.smallscene.dao.RoleMapper;
import com.kelan.smallscene.dao.UserMapper;
import com.kelan.smallscene.dao.UserRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>框架需要使用到一个实现了UserDetailsService接口的类</p>
 * @author jiaoguang
 * @version V1.0.0
 * @class UserServiceImpl
 * @date 2019/3/17 16:08
 * @Copyright
 */
@Service
public class UserServiceImpl implements UserDetailsService {
  private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private RoleMapper roleMapper;
  @Autowired
  private UserRoleMapper userRoleMapper;

  /**
   * <p>根据用户名 返回一个UserDetails的实现类的实例</p>
   * @method loadUserByUsername
   * @author jiaoguang
   * @date 2019/3/17 18:09
   * @param s 用户账号
   * @return org.springframework.security.core.userdetails.UserDetails
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    try{
      User user = userMapper.selectByUserAccount(s);
      if(user == null){
        throw new UsernameNotFoundException("没有该用户");
      }
      List<String> roleUUIDList = userRoleMapper.selectByUserUUID(user.getUserUuid());
      if(roleUUIDList == null || roleUUIDList.size() < 1) {
        return new UserDetailsImpl(user);
      }
      List<Role> roleList = roleMapper.selectByRoleUUIDList(roleUUIDList);
      return new UserDetailsImpl(user, roleList);
    }catch (Exception e) {
      logger.error("角色查询异常");
      e.printStackTrace();
      return null;
    }
  }
}
