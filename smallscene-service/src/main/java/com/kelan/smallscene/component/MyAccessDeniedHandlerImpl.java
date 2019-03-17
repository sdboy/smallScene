package com.kelan.smallscene.component;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>自定义403响应内容</p>
 * @author jiaoguang
 * @version V1.0.0
 * @class AccessDeniedHandlerImpl
 * @date 2019/3/17 18:55
 * @Copyright
 */
@Component
public class MyAccessDeniedHandlerImpl implements AccessDeniedHandler {

  /**
   * Handles an access denied failure.
   *
   * @param request               that resulted in an <code>AccessDeniedException</code>
   * @param response              so that the user agent can be advised of the failure
   * @param accessDeniedException that caused the invocation
   * @throws IOException      in the event of an IOException
   * @throws ServletException in the event of a ServletException
   */
  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();
    out.write("{\"status\":403,\"msg\":\"权限不足，请联系管理员!\"}");
    out.flush();
    out.close();
  }
}
