package com.nagp.utils;

import static com.nagp.contants.FrameworkConstants.getConfigFilePath;
import static com.nagp.contants.MessageConstants.ERROR_MESSAGE_PROPERTY_NOT_FOUND;
import static java.lang.String.format;
import static java.util.Objects.isNull;

import com.nagp.exceptions.PropertyNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Read the property file and store it in a HashMap for faster processing.
 */
public final class PropertyUtils {

  /**
   * Private constructor to avoid external instantiation
   */
  private PropertyUtils() {
  }

  private static final Properties properties = new Properties();
  private static final Map<String, String> configMap = new HashMap<>();

  static {
    try {
      properties.load(new FileInputStream(getConfigFilePath()));

      properties.forEach((key, value) -> configMap.put((String) key, (String) value));
    } catch (IOException e) {
      System.exit(0);
    }
  }

  /**
   * @param key to be fetched from property file
   * @return corresponding value for the requested key if found else {@link
   * PropertyNotFoundException}
   */
  public static String getValue(String key) {

    if (isNull(configMap.get(key))) {
      throw new PropertyNotFoundException(format(ERROR_MESSAGE_PROPERTY_NOT_FOUND, key));
    }
    return configMap.get(key);
  }
}
