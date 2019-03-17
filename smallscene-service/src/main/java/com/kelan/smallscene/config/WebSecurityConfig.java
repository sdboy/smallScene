package com.kelan.smallscene.config;

import com.kelan.smallscene.component.AccessDecisionManagerImpl;
import com.kelan.smallscene.component.MyAccessDeniedHandlerImpl;
import com.kelan.smallscene.component.FilterInvocationSecurityMetadataSourceImpl;
import com.kelan.smallscene.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jiaoguang
 * @version V1.0.0
 * @class WebSecurityConfig
 * @date 2019/3/17 18:52
 * @Copyright
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserServiceImpl userService;
  @Autowired
  private FilterInvocationSecurityMetadataSourceImpl filterInvocationSecurityMetadataSource;
  @Autowired
  private AccessDecisionManagerImpl accessDecisionManager;
  @Autowired
  private MyAccessDeniedHandlerImpl accessDeniedHandler;

  /**
   * <p>定义认证用户信息获取来源，密码校验规则等</p>
   * @method configure
   * @author jiaoguang
   * @date 2019/3/17 19:08
   * @param auth 整整管理
   * @return void
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // 有以下几种形式，使用第3种
    // inMemoryAuthentication 从内存中获取
    // auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user1").password(new BCryptPasswordEncoder().encode("123123")).roles("USER");

    // jdbcAuthentication从数据库中获取，但是默认是以security提供的表结构
    // usersByUsernameQuery 指定查询用户SQL
    // authoritiesByUsernameQuery 指定查询权限SQL
    // auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(query);

    // 注入userService，需要实现userDetailsService接口
    auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
  }

  /**
   * <p>在这里配置哪些页面不需要认证</p>
   * @method configure
   * @author jiaoguang
   * @date 2019/3/17 19:09
   * @param web 页面
   * @return void
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/", "/noAuthenticate");
  }

  /**
   * <p>定义安全策略</p>
   * @method configure
   * @author jiaoguang
   * @date 2019/3/17 19:10
   * @param http 请求
   * @return void
   * @since V1.0.0
   * @version V1.0.0
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 配置安全策略
    http.authorizeRequests()
        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
          @Override
          public <O extends FilterSecurityInterceptor> O postProcess(O o) {
            o.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
            o.setAccessDecisionManager(accessDecisionManager);
            return o;
          }
        })
//                .antMatchers("/hello").hasAuthority("ADMIN")
        .and()
        .formLogin()
        .loginPage("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        .permitAll()
        .failureHandler(new AuthenticationFailureHandler() {
          @Override
          public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                              HttpServletResponse httpServletResponse,
                                              AuthenticationException e) throws IOException, ServletException {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();
            StringBuffer sb = new StringBuffer();
            sb.append("{\"status\":\"error\",\"msg\":\"");
            if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
              sb.append("用户名或密码输入错误，登录失败!");
            } else if (e instanceof DisabledException) {
              sb.append("账户被禁用，登录失败，请联系管理员!");
            } else {
              sb.append("登录失败!");
            }
            sb.append("\"}");
            out.write(sb.toString());
            out.flush();
            out.close();
          }
        })
        .successHandler(new AuthenticationSuccessHandler() {
          @Override
          public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                              HttpServletResponse httpServletResponse,
                                              Authentication authentication) throws IOException, ServletException {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();
//                        ObjectMapper objectMapper = new ObjectMapper();
            String s = "{\"status\":200,\"msg\":"  + "}";
            out.write(s);
            out.flush();
            out.close();
          }
        })
        .and()
        .logout()
        .permitAll()
        .and()
        .csrf()
        .disable()
        .exceptionHandling()
        .accessDeniedHandler(accessDeniedHandler);
  }
}
