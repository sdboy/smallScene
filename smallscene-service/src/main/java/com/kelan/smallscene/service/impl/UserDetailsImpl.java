package com.kelan.smallscene.service.impl;

import com.kelan.smallscene.bean.Role;
import com.kelan.smallscene.bean.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/3/15 16:48
 * @see
 */
public class UserDetailsImpl implements UserDetails {

  private String username;
  private String password;
  /**
   * 包含着用户对应的所有Role，在使用时调用者给对象注入roles
   */
  private List<Role> roles;

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public UserDetailsImpl() {

  }

  public UserDetailsImpl(User user) {
    this.username = user.getUserAccount();
    this.password = user.getUserPwd();
  }

  /**
   * <p>用User和List<Role>构造</p>
   * @method UserDetailsImpl
   * @author JG
   * @date 2019/3/15 16:56
   * @param user 用户
   * @param roles 角色
   * @since V1.0.0
   * @version V1.0.0
   */
  public UserDetailsImpl(User user, List<Role> roles) {
    this.username = user.getUserAccount();
    this.password = user.getUserPwd();
    this.roles = roles;
  }

  /**
   * <p>返回用户所有角色的封装，一个Role对应一个GrantedAuthority</p>
   * @method getAuthorities
   * @author JG
   * @date 2019/3/15 17:00
   * @return java.util.Collection<? extends org.springframework.security.core.GrantedAuthority>
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for(Role role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    }
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }
  /**
   * <p>判断账号是否已经过期，默认没有过期</p>
   * @method isAccountNonExpired
   * @author JG
   * @date 2019/3/15 17:01
   * @return boolean
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * <p>判断账号是否被锁定，默认没有锁定</p>
   * @method isAccountNonLocked
   * @author JG
   * @date 2019/3/15 17:02
   * @return boolean
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * <p>判断信用凭证是否过期，默认没有过期</p>
   * @method isCredentialsNonExpired
   * @author JG
   * @date 2019/3/15 17:02
   * @return boolean
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * <p>判断账号是否可用，默认可用</p>
   * @method isEnabled
   * @author JG
   * @date 2019/3/15 17:02
   * @return boolean
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  public boolean isEnabled() {
    return true;
  }
}
