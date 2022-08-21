package com.nagp.driver;


import static com.nagp.contants.FrameworkConstants.SEPARATOR;
import static com.nagp.contants.FrameworkConstants.getAppDir;
import static com.nagp.contants.FrameworkConstants.getAppName;
import static com.nagp.contants.FrameworkConstants.getImplicitWait;
import static com.nagp.contants.FrameworkConstants.getWebdriverHub;
import static com.nagp.driver.DriverManager.getDriver;
import static com.nagp.driver.DriverManager.setDriver;
import static com.nagp.utils.PropertyUtils.getValue;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Driver class is responsible for invoking and closing the browser. It is also responsible for
 * setting the driver variable to DriverManager.
 */
public final class Driver {

  /**
   * Private constructor for avoiding external instantiation.
   */
  private Driver() {
  }

  /**
   * Initialise the browser and set the capabilities for the Driver
   */
  public static void initializeDriver() {
    if (isNull(getDriver())) {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(APP, getAppDir() + getAppName());
      capabilities.setCapability(PLATFORM_NAME, getValue("platformName"));
      capabilities.setCapability(DEVICE_NAME, getValue("deviceName"));
      String url = getValue("server") + SEPARATOR + getValue("portNumber") + getWebdriverHub();
      try {
        setDriver(
            new AndroidDriver(new URL(url), capabilities));
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      getDriver().manage().timeouts().implicitlyWait(getImplicitWait(), SECONDS);
    }

  }

  /**
   * Terminates the browser instance.
   */
  public static void quitDriver() {
    if (nonNull(getDriver())) {
      getDriver().quit();
      setDriver(null);
    }
  }

}
