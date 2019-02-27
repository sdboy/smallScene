package com.kelan.smallscene.service.impl;

import com.kelan.smallscene.bean.Department;
import com.kelan.smallscene.common.ServerResponse;
import com.kelan.smallscene.dao.DepartmentMapper;
import com.kelan.smallscene.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/1/8 10:57
 * @see
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  private final static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

  @Autowired
  private DepartmentMapper departmentMapper;

  @Override
  public ServerResponse<String> addDepartment(Department department) {
    return null;
  }
}
