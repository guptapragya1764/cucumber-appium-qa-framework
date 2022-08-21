package com.nagp.contants;

import static java.lang.System.getProperty;

/**
 * FrameworkConstants holds the value of all the constant values used within the framework except
 * the message constants.
 */
public final class FrameworkConstants {

  /**
   * Private constructor to avoid external instantiation.
   */
  private FrameworkConstants() {
  }

  private static final String USERDIR = getProperty("user.dir");
  private static final String TESTRESOURCESPATH = USERDIR + "/src/test/resources/";
  private static final String WEBDRIVERHUB = "/wd/hub";
  private static final String APPDIR = TESTRESOURCESPATH + "app/";
  private static final String APPNAME = "base.apk";
  private static final int IMPLICITWAIT = 25;
  private static final int EXPLICITWAIT = 20;
  private static final long SWIPE_WAIT = 2;
  private static final String CONFIGFILEPATH = TESTRESOURCESPATH + "config/config.properties";

  public static final String SEPARATOR = ":";
  private static final String TESTOUTPUTPATH = USERDIR + "/test-output/";
  private static final String CURRENTTESTRESULTPATH = TESTOUTPUTPATH + "current-test-results/";
  private static final String ARCHIVEDTESTRESULTPATH = TESTOUTPUTPATH + "archived-test-results/";
  private static final String LOGFOLDERPATH = USERDIR + "/logs/";
  private static final String CURRENTLOGOFOLDERPATH = "current/";
  private static final String ARCHIVEDLOGOFOLDERPATH = LOGFOLDERPATH + "archived/";
  private static final String EXTENTREPORTPATH = "extentReport/index.html";
  private static long currentTimeStamp = 0;

  public static String getWebdriverHub() {
    return WEBDRIVERHUB;
  }

  public static String getAppDir() {
    return APPDIR;
  }

  public static int getImplicitWait() {
    return IMPLICITWAIT;
  }

  public static int getExplicitWait() {
    return EXPLICITWAIT;
  }

  public static long getSwipeWait() {
    return SWIPE_WAIT;
  }

  public static String getConfigFilePath() {
    return CONFIGFILEPATH;
  }

  public static String getAppName() {
    return APPNAME;
  }

  private static long getCurrentTimeStamp() {
    if (currentTimeStamp == 0) {
      currentTimeStamp = System.currentTimeMillis();
    }
    return currentTimeStamp;
  }

  public static String getCurrentTestResultPath() {
    return CURRENTTESTRESULTPATH;
  }

  public static String getArchivedTestResultPath() {
    return ARCHIVEDTESTRESULTPATH;
  }

  public static String getCurrentTestResultPathWithTimeStampFolder() {
    return CURRENTTESTRESULTPATH + getCurrentTimeStamp() + "/";
  }

  public static String getCurrentExtentReportPath() {
    return getCurrentTestResultPathWithTimeStampFolder() + EXTENTREPORTPATH;
  }

  public static String getLogoFolderPath() {
    return LOGFOLDERPATH;
  }

  public static String getCurrentLogoFolderPath() {
    return CURRENTLOGOFOLDERPATH;
  }

  public static String getArchivedLogoFolderPath() {
    return ARCHIVEDLOGOFOLDERPATH;
  }

  public static String getCurrentLogoFolderPathWithTimeStamp() {
    return CURRENTLOGOFOLDERPATH + getCurrentTimeStamp() + "/";
  }


}