package com.kelan.smallscene.config;

import com.kelan.smallscene.listener.JmsMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.util.backoff.FixedBackOff;

import javax.jms.ConnectionFactory;
import javax.jms.Session;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/1/5 15:49
 * @see
 */
//@Configuration
public class ActiveMQConfig {
  /**
   * mq地址
   */
  @Value(value = "${FACE.url}")
  private String url;
  /**
   * 消费者id
   */
  @Value(value = "${FACE.clientId}")
  private String clientId;
  /**
   * 会话数量
   */
  @Value(value = "${FACE.sessionCacheSize}")
  private int sessionCacheSize;
  /**
   * 主题名
   */
  @Value(value = "${FACE.image.topic}")
  private String imageTopic;
  /**
   * 主题名
   */
  @Value(value = "${FACE.match.topic}")
  private String matchTopic;
  /**
   * 重连间隔时间，单位毫秒
   */
  @Value(value = "${FACE.interval}")
  private long interval;
  /**
   * 最大重连次数
   */
  @Value(value = "${FACE.maxAttempts}")
  private long maxAttempts;
  /**
   * 接受消息超时，单位毫秒
   */
  @Value(value = "${FACE.receiveTimeout}")
  private long receiveTimeout;
  /**
   * 是否持久化，true为是，false为否
   */
  @Value(value = "${FACE.subscriptionDurable}")
  private boolean subscriptionDurable;
  /**
   * 持久化名称
   */
  @Value(value = "${FACE.durableSubscriptionName}")
  private String durableSubscriptionName;

  @Bean
  public ActiveMQConnectionFactory faceConnectionFactory() {
    ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory();
    mqConnectionFactory.setBrokerURL(url);
    return mqConnectionFactory;
  }

  @Bean
  public CachingConnectionFactory faceCachingConnectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setSessionCacheSize(sessionCacheSize);
    connectionFactory.setTargetConnectionFactory(faceConnectionFactory());
    connectionFactory.setClientId(clientId);
    return connectionFactory;
  }

  @Bean
  public ActiveMQTopic faceImageTopic() {
    ActiveMQTopic mqTopic = new ActiveMQTopic();
    mqTopic.setPhysicalName(imageTopic);
    return mqTopic;
  }

  @Bean
  public ActiveMQTopic faceMatchTopic() {
    ActiveMQTopic mqTopic = new ActiveMQTopic();
    mqTopic.setPhysicalName(matchTopic);
    return mqTopic;
  }

  @Bean
  public JmsMessageListener faceImageMessageListener() {
    return new JmsMessageListener();
  }

  @Bean
  public JmsMessageListener faceMatchMessageListener() {
    return new JmsMessageListener();
  }

  @Bean
  public MessageListenerAdapter faceImageMessageListenerAdapter() {
    MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter();
    messageListenerAdapter.setDelegate(faceImageMessageListener());
    messageListenerAdapter.setDefaultListenerMethod("onMessage");
    return messageListenerAdapter;
  }

  @Bean
  public MessageListenerAdapter faceMatchMessageListenerAdapter() {
    MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter();
    messageListenerAdapter.setDelegate(faceMatchMessageListener());
    messageListenerAdapter.setDefaultListenerMethod("onMessage");
    return messageListenerAdapter;
  }

  @Bean
  public FixedBackOff fixedBackOff() {
    FixedBackOff fixedBackOff = new FixedBackOff();
    fixedBackOff.setInterval(interval);
    fixedBackOff.setMaxAttempts(maxAttempts);
    return fixedBackOff;
  }

  @Bean
  public DefaultMessageListenerContainer topicImageMessageListenerAdapterContainer() {
    DefaultMessageListenerContainer listenerContainer = new DefaultMessageListenerContainer();
    listenerContainer.setConnectionFactory(faceCachingConnectionFactory());
    listenerContainer.setDestination(faceImageTopic());
    listenerContainer.setMessageListener(faceImageMessageListenerAdapter());
    listenerContainer.setPubSubDomain(Boolean.TRUE);
    listenerContainer.setBackOff(fixedBackOff());
    listenerContainer.setClientId(clientId);
    listenerContainer.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
    listenerContainer.setReceiveTimeout(receiveTimeout);
    if(subscriptionDurable && StringUtils.isNotBlank(durableSubscriptionName)) {
      listenerContainer.setSubscriptionDurable(subscriptionDurable);
      listenerContainer.setDurableSubscriptionName(durableSubscriptionName);
    }
    return listenerContainer;
  }

  @Bean
  public DefaultMessageListenerContainer topicMatchMessageListenerAdapterContainer() {
    DefaultMessageListenerContainer listenerContainer = new DefaultMessageListenerContainer();
    listenerContainer.setConnectionFactory(faceCachingConnectionFactory());
    listenerContainer.setDestination(faceMatchTopic());
    listenerContainer.setMessageListener(faceMatchMessageListenerAdapter());
    listenerContainer.setPubSubDomain(Boolean.TRUE);
    listenerContainer.setBackOff(fixedBackOff());
    listenerContainer.setClientId(clientId);
    listenerContainer.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
    listenerContainer.setReceiveTimeout(receiveTimeout);
    if(subscriptionDurable && StringUtils.isNotBlank(durableSubscriptionName)) {
      listenerContainer.setSubscriptionDurable(subscriptionDurable);
      listenerContainer.setDurableSubscriptionName(durableSubscriptionName);
    }
    return listenerContainer;
  }

  @Bean
  public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setPubSubDomain(true);
    factory.setConnectionFactory(connectionFactory);
    factory.setBackOff(fixedBackOff());
    return factory;
  }

  @Bean
  public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setPubSubDomain(false);
    factory.setConnectionFactory(connectionFactory);
    factory.setBackOff(fixedBackOff());
    return factory;
  }
}
