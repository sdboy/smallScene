package com.kelan.smallscene.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/1/7 13:24
 * @see
 */
@Component
public class ConsumerTest {
  @JmsListener(id = "123", destination = "topic")
  public void consumer(String message) {

  }
}
