package com.kelan.smallscene.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/1/7 22:44
 * @see
 */
//@Configuration
//@EnableCaching
public class RedisConfig {

  /**
   * <p>以字符串序列化</p>
   * @method stringRedisSerializer
   * @author JG
   * @date 2018/12/14 17:28
   * @return org.springframework.data.redis.serializer.StringRedisSerializer
   * @since V1.0.0
   * @version V1.0.0
   */
  @Bean
  public StringRedisSerializer stringRedisSerializer() {
    return new StringRedisSerializer();
  }

  /**
   * <p>json序列化</p>
   * @method genericFastJsonRedisSerializer
   * @author JG
   * @date 2018/12/14 17:29
   * @return com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer
   * @since V1.0.0
   * @version V1.0.0
   */
  @Bean
  public GenericFastJsonRedisSerializer genericFastJsonRedisSerializer() {
    return new GenericFastJsonRedisSerializer();
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    // 事务支持，redis集群模式要关掉
    template.setEnableTransactionSupport(false);
    template.setKeySerializer(stringRedisSerializer());
    template.setValueSerializer(genericFastJsonRedisSerializer());
    template.setHashKeySerializer(stringRedisSerializer());
    template.setHashValueSerializer(genericFastJsonRedisSerializer());
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }

  @Bean
  public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
    stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
    stringRedisTemplate.setEnableTransactionSupport(true);
    return stringRedisTemplate;
  }

  /**
   * <p>配置cacheManager</p>
   * @method cacheManager
   * @author JG
   * @date 2018/12/18 10:42
   * @return org.springframework.cache.CacheManager
   * @since V1.0.0
   * @version V1.0.0
   */
  @Bean
  public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().
        entryTtl(Duration.ofHours(1));

    return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(
        redisConnectionFactory)).cacheDefaults(redisCacheConfiguration).build();
  }
}
