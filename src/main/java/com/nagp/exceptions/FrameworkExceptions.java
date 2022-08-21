package com.nagp.exceptions;

/**
 * Base Exception for the framework and it can throw exception anywhere to terminate the program.
 */
public class FrameworkExceptions extends RuntimeException {

  /**
   * Pass the message that need to be appended with stacktrace.
   *
   * @param message Details about exception or custom message.
   */
  public FrameworkExceptions(String message) {
    super(message);
  }

  /**
   * @param message        Details about the exception or custom message
   * @param throwableCause Pass the customised stacktrace
   */
  public FrameworkExceptions(String message, Throwable throwableCause) {
    super(message, throwableCause);
  }

}
