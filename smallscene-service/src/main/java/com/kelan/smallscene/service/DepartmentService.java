package com.kelan.smallscene.service;

import com.kelan.smallscene.bean.Department;
import com.kelan.smallscene.common.ServerResponse;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/1/8 10:54
 * @see
 */
public interface DepartmentService {
  /**
   * <p>添加组织信息</p>
   * @method addDepartment
   * @author JG
   * @date 2019/1/8 10:56
   * @param department 组织信息
   * @return com.kelan.smallscene.common.ServerResponse<java.lang.String>
   * @since V1.0.0
   * @version V1.0.0
   */
  public ServerResponse<String> addDepartment(Department department);
}
