package com.kelan.smallscene.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2018/8/10 17:17
 * @see
 */
public class PropertiesUtil {
  private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
  private static Properties props;
  static {
    String fileName = "datasource.properties";
    props = new Properties();
    try {
      props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
    } catch (IOException e) {
      logger.error("配置文件读取异常", e);
    }
  }
  public static String getPorperty(String key) {
    String value = props.getProperty(key.trim());
    if(StringUtils.isBlank(value)) {
      return null;
    }
    return value.trim();
  }

  public static String getPorperty(String key, String defaultValue) {
    String value = props.getProperty(key.trim());
    if(StringUtils.isBlank(value)) {
      value = defaultValue;
    }
    return value.trim();
  }
}
