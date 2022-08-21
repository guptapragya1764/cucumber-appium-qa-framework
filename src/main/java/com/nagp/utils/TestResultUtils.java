package com.nagp.utils;


import static com.nagp.contants.FrameworkConstants.getCurrentExtentReportPath;
import static com.nagp.contants.MessageConstants.ERROR_MESSAGE_COPYING_DIR_CONTENTS;
import static com.nagp.contants.MessageConstants.ERROR_MESSAGE_DELETING_DIR_CONTENTS;
import static com.nagp.factory.LoggerFactory.info;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.io.FileUtils.copyDirectory;
import static org.apache.commons.io.FileUtils.deleteDirectory;
import static org.apache.tools.ant.util.FileUtils.delete;

import java.io.File;
import java.io.IOException;

/**
 * Utility for creating test results.
 */
public final class TestResultUtils {

  /**
   * Private constructor to avoid external instantiation
   */
  private TestResultUtils() {
  }

  /**
   * Moves source folder content to destination folder.
   *
   * @param srcDir  Source folder File
   * @param destDir Destination folder File
   */
  public static void moveFoldersContents(String srcDir, String destDir) {
    File srcFile = new File(srcDir);
    File destFile = new File(destDir);
    try {
      copyDirectory(srcFile, destFile);
    } catch (IOException e) {
      info(format(ERROR_MESSAGE_COPYING_DIR_CONTENTS, srcDir, srcFile));
    }
    if (srcFile.exists()) {
      for (File file : requireNonNull(srcFile.listFiles())) {
        try {
          if (file.isDirectory()) {
            deleteDirectory(file);
          } else {
            delete(file);
          }
        } catch (IOException ex) {
          info(format(ERROR_MESSAGE_DELETING_DIR_CONTENTS, file, srcFile));
        }
      }
    }
  }

  /**
   * This method sets the location where extent report would be generated
   */
  public static void setExtentReportLocation() {
    System.setProperty("extent.reporter.spark.out", getCurrentExtentReportPath());
  }

  public static void waitTill(long seconds){
    try {
      Thread.sleep(seconds*1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

