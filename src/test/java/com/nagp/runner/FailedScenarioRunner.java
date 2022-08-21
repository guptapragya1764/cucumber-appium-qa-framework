package com.nagp.runner;

import static com.nagp.contants.FrameworkConstants.getArchivedLogoFolderPath;
import static com.nagp.contants.FrameworkConstants.getArchivedTestResultPath;
import static com.nagp.contants.FrameworkConstants.getCurrentExtentReportPath;
import static com.nagp.contants.FrameworkConstants.getCurrentLogoFolderPath;
import static com.nagp.contants.FrameworkConstants.getCurrentTestResultPath;
import static com.nagp.contants.FrameworkConstants.getLogoFolderPath;
import static com.nagp.factory.FileFactory.deleteFile;
import static com.nagp.utils.TestResultUtils.moveFoldersContents;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
    features = {"@test-output/FailedScenarios.txt"},
    glue = {"com.nagp.steps"},
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:test-output/FailedScenarios.txt"}
)
public class FailedScenarioRunner extends AbstractTestNGCucumberTests {

  AppiumDriverLocalService service;

  @BeforeSuite
  public void startServer() {
    System.setProperty("extent.reporter.spark.out", getCurrentExtentReportPath());
    service = AppiumDriverLocalService.buildDefaultService();
    service.start();
    moveFoldersContents(getCurrentTestResultPath(), getArchivedTestResultPath());
    moveFoldersContents(getLogoFolderPath() + getCurrentLogoFolderPath(),
        getArchivedLogoFolderPath());
  }

  @AfterSuite
  public void stopServer() throws IOException {
    deleteFile(getLogoFolderPath() + "${ctx");
    service.stop();
    Desktop.getDesktop().browse(new File(getCurrentExtentReportPath()).toURI());
  }

}
