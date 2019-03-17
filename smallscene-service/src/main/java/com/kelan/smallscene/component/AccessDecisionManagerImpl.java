package com.kelan.smallscene.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * <p>
 * Security需要用到一个实现了AccessDecisionManager接口的类类功能：根据当前用户的信息，
 * 和目标url涉及到的权限，判断用户是否可以访问判断规则：用户只要匹配到目标url权限中的一个role就可以访问
 * </p>
 * @author jiaoguang
 * @version V1.0.0
 * @class AccessDecisionManagerImpl
 * @date 2019/3/17 18:45
 * @Copyright
 */
@Component
public class AccessDecisionManagerImpl implements AccessDecisionManager {
  private final static Logger logger = LoggerFactory.getLogger(AccessDecisionManagerImpl.class);
  /**
   * Resolves an access control decision for the passed parameters.
   *
   * @param authentication   the caller invoking the method (not null)
   * @param object           the secured object being called
   * @param configAttributes the configuration attributes associated with the secured
   *                         object being invoked
   * @throws AccessDeniedException               if access is denied as the authentication does not
   *                                             hold a required authority or ACL privilege
   * @throws InsufficientAuthenticationException if access is denied as the
   *                                             authentication does not provide a sufficient level of trust
   */
  @Override
  public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws
      AccessDeniedException, InsufficientAuthenticationException {
    //迭代器遍历目标url的权限列表
    Iterator<ConfigAttribute> iterator = configAttributes.iterator();
    while (iterator.hasNext()) {
      ConfigAttribute ca = iterator.next();

      String needRole = ca.getAttribute();
      if ("ROLE_LOGIN".equals(needRole)) {
        if (authentication instanceof AnonymousAuthenticationToken) {
          throw new BadCredentialsException("未登录");
        } else {
          return;
        }
      }

      //遍历当前用户所具有的权限
      Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
      for (GrantedAuthority authority : authorities) {
        if (authority.getAuthority().equals(needRole)) {
          return;
        }
      }
    }

    //执行到这里说明没有匹配到应有权限
    throw new AccessDeniedException("权限不足!");
  }

  /**
   * Indicates whether this <code>AccessDecisionManager</code> is able to process
   * authorization requests presented with the passed <code>ConfigAttribute</code>.
   * <p>
   * This allows the <code>AbstractSecurityInterceptor</code> to check every
   * configuration attribute can be consumed by the configured
   * <code>AccessDecisionManager</code> and/or <code>RunAsManager</code> and/or
   * <code>AfterInvocationManager</code>.
   * </p>
   *
   * @param attribute a configuration attribute that has been configured against the
   *                  <code>AbstractSecurityInterceptor</code>
   * @return true if this <code>AccessDecisionManager</code> can support the passed
   * configuration attribute
   */
  @Override
  public boolean supports(ConfigAttribute attribute) {
    return false;
  }

  /**
   * Indicates whether the <code>AccessDecisionManager</code> implementation is able to
   * provide access control decisions for the indicated secured object type.
   *
   * @param clazz the class that is being queried
   * @return <code>true</code> if the implementation can process the indicated class
   */
  @Override
  public boolean supports(Class<?> clazz) {
    return false;
  }
}
