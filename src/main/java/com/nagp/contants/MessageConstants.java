package com.nagp.contants;

/**
 * MessageConstants holds the value of all the message constant values used within the framework.
 */
public final class MessageConstants {

  /**
   * Private constructor to avoid external instantiation.
   */
  private MessageConstants() {
  }

  public static final String ERROR_MESSAGE_DELETING_DIR_CONTENTS = "Unable to delete %s from directory %s. Please check";
  public static final String TESTCASE_EXECUTION_START_MESSAGE = "\n\n***** Execution Started : %s *****\n";
  public static final String TESTCASE_EXECUTION_END_MESSAGE = "\n\n***** Execution End : %s is %s *****\n";
  public static final String ERROR_MESSAGE_COPYING_DIR_CONTENTS = "Unable to directory Content from %s to %s. Please check extent the contents of Directory or Directory itself";
  public static final String ERROR_MESSAGE_PROPERTY_NOT_FOUND = "Property name %s is not found. Please check the config.properties";
  public static final String ERROR_MESSAGE_FOR_TEXT_FOCUS_START = "Assert is failing as expected and actual text for Focus Start Page is not matching";
  public static final String ERROR_MESSAGE_FOR_SUBSESCTIONS = "Assertion is failed. Expected Subsection for 'Pass it On' was: %s but found: %s";
  public static final String ERROR_MESSAGE_FOR_SUBHEADER = "Assertion is failing for Sub-header %s in bucket %s";
  public static final String ERROR_MESSAGE_FOR_SUBTEXT = "Assertion is failing for Sub-text %s in bucket %s";

}
