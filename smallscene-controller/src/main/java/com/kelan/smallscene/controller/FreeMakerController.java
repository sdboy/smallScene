package com.kelan.smallscene.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/1/5 14:54
 * @see
 */
@Controller
@RequestMapping(value = "test")
public class FreeMakerController {
  @RequestMapping(value = "index", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
  public String test() {
    return "index";
  }
}
