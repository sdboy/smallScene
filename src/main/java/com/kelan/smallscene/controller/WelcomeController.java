package com.kelan.smallscene.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/1/5 11:11
 * @see
 */
@Controller
@RequestMapping(value = "welcome")
public class WelcomeController {
  @RequestMapping(value = "hello")
  public String welcome() {
    return "index";
  }
}
