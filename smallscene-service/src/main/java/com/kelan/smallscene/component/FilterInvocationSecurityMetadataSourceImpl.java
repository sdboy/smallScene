package com.kelan.smallscene.component;

import com.kelan.smallscene.bean.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class FilterInvocationSecurityMetadataSourceImpl
 * @date 2019/3/17 18:15
 * @Copyright
 */
@Component
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {
  private final static Logger logger = LoggerFactory.getLogger(FilterInvocationSecurityMetadataSourceImpl.class);

  /**
   * <p>接收用户请求的地址，返回访问该地址需要的所有权限</p>
   * @method getAttributes
   * @author jiaoguang
   * @date 2019/3/17 18:19
   * @param o 地址
   * @return java.util.Collection<org.springframework.security.access.ConfigAttribute>
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
    // 得到用户的请求地址,控制台输出一下
    String requestUrl = ((FilterInvocation) o).getRequestUrl();
    logger.debug("用户请求的地址是：" + requestUrl);
    // 如果登录页面就不需要权限
    if ("/login/index".equals(requestUrl)) {
      return null;
    }

    Resource resource = resourceService.getResourceByUrl(requestUrl);

    // 如果没有匹配的url则说明大家都可以访问
    if(resource == null) {
      return SecurityConfig.createList("ROLE_LOGIN");
    }

    // 将resource所需要到的roles按框架要求封装返回（ResourceService里面的getRoles方法是基于RoleRepository实现的）
    List<Role> roles = resourceService.getRoles(resource.getId());
    int size = roles.size();
    String[] values = new String[size];
    for (int i = 0; i < size; i++) {
      values[i] = roles.get(i).getRoleName();
    }
    return SecurityConfig.createList(values);
  }

  /**
   * If available, returns all of the {@code ConfigAttribute}s defined by the
   * implementing class.
   * <p>
   * This is used by the {@link AbstractSecurityInterceptor} to perform startup time
   * validation of each {@code ConfigAttribute} configured against it.
   *
   * @return the {@code ConfigAttribute}s or {@code null} if unsupported
   */
  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  /**
   * Indicates whether the {@code SecurityMetadataSource} implementation is able to
   * provide {@code ConfigAttribute}s for the indicated secure object type.
   *
   * @param clazz the class that is being queried
   * @return true if the implementation can process the indicated class
   */
  @Override
  public boolean supports(Class<?> clazz) {
    return false;
  }

}
