package com.kelan.smallscene.controller;

import com.kelan.smallscene.entity.ReceiveMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/1/7 17:38
 * @see
 */
@Configuration
public class WebSocketController {

  @Autowired
  private SimpMessagingTemplate template;

  @MessageMapping(value = "subscribe")
  public void TopicMessage(ReceiveMessage rm) {
    template.convertAndSend("/topic/getResponse", rm.getName());
  }

  @MessageMapping(value = "queue")
  public void QueueMessage(ReceiveMessage rm) {
    template.convertAndSendToUser("zhangsan", "/message", rm.getName());
  }
}
