package com.nagp.driver;

import io.appium.java_client.android.AndroidDriver;

/**
 * DriverManager class helps to achieve thread safety for AndroidDriver instance.
 */
public final class DriverManager {

  /**
   * Private constructor to avoid external instantiation
   */
  private DriverManager() {
  }

  private static ThreadLocal<AndroidDriver> driverThreadLocal = new ThreadLocal();

  /**
   * Set the AndroidDriver instance to thread local variable.
   *
   * @param driver AndroidDriver instance that needs to saved from Thread safety issues.
   */
  public static void setDriver(AndroidDriver driver) {
    driverThreadLocal.set(driver);
  }

  /**
   * Returns the thread safe AndroidDriver instance fetched from ThreadLocal variable.
   *
   * @return AndroidDriver instance.
   */
  public static AndroidDriver getDriver() {
    return driverThreadLocal.get();
  }
}
