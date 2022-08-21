package com.nagp.factory;

import static com.nagp.contants.FrameworkConstants.getCurrentLogoFolderPathWithTimeStamp;
import static com.nagp.contants.MessageConstants.TESTCASE_EXECUTION_END_MESSAGE;
import static com.nagp.contants.MessageConstants.TESTCASE_EXECUTION_START_MESSAGE;
import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static org.apache.logging.log4j.ThreadContext.put;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class is responsible for generating logs in File and Console
 */
public final class LoggerFactory {

  private LoggerFactory() {
  }

  private static Logger logger = LogManager.getLogger();

  /**
   * Writes the log for informing about starting of the test case execution and calls the method
   * which generates file for logs
   *
   * @param testCaseName Name of the testcase that needs to printed on logs.
   */
  public static synchronized void startTestCase(String testCaseName) {
    startLog(testCaseName);
    info(format(TESTCASE_EXECUTION_START_MESSAGE, testCaseName));
  }

  /**
   * Writes the log for informing about ending of the test case execution.
   *
   * @param testCaseName Name of the testcase that needs to printed on logs.
   * @param status       status of testcase execution.
   */
  public static void endTestCase(String testCaseName, String status) {
    info(format(TESTCASE_EXECUTION_END_MESSAGE, testCaseName, status));
  }


  private static void startLog(String testCaseName) {
    put("logFilename", getCurrentLogoFolderPathWithTimeStamp() + (testCaseName.replace(" ", "_")));
  }

  public static Logger getCurrentLog() {
    return logger;
  }

  public static String getCallInfo() {
    String callInfo;
    String className = currentThread().getStackTrace()[3].getClassName();
    String methodName = currentThread().getStackTrace()[3].getMethodName();
    callInfo = className + ":" + methodName + " --> ";
    return callInfo;
  }

//  public static void trace(Object message) {
//    getCurrentLog().trace(message);
//  }

//  public static void debug(Object message) {
//    getCurrentLog().debug(getCallInfo() + message);
//  }

//  public static void error(Object message) {
//
//    getCurrentLog().error(getCallInfo() + message);
//  }

//  public static void fatal(Object message) {
//    getCurrentLog().fatal(getCallInfo() + message);
//  }

  public static void info(Object message) {

    getCurrentLog().info(getCallInfo() + message);
  }

//  public static void warn(Object message) {
//    getCurrentLog().warn(getCallInfo() + message);
//  }


}
