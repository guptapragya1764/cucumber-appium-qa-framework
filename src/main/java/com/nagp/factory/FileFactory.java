package com.nagp.factory;

//import static com.nagp.constants.MessageConstants.ERROR_MESSAGE_FILE_NOT_FOUND;
//import static java.lang.ClassLoader.getSystemClassLoader;
//import static java.util.Objects.requireNonNull;
//
//import com.nagp.exceptions.IncorrectFilePathException;

import static com.nagp.contants.FrameworkConstants.getLogoFolderPath;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * This class acts as factory for producing File Object.
 */
public final class FileFactory {

  /**
   * Private constructor to avoid external instantiation.
   */
  private FileFactory() {
  }

  public static void deleteFile(String filePath) {
    File file = new File(filePath);
    if (file.exists()) {
      FileUtils.deleteQuietly(file);
    }
  }

  public static void removeExtraFileInLogs() {
    deleteFile(getLogoFolderPath() + "${ctx");
  }

}
