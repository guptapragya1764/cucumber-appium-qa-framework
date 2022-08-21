package com.nagp.runner;

import static com.nagp.contants.FrameworkConstants.getArchivedLogoFolderPath;
import static com.nagp.contants.FrameworkConstants.getArchivedTestResultPath;
import static com.nagp.contants.FrameworkConstants.getCurrentExtentReportPath;
import static com.nagp.contants.FrameworkConstants.getCurrentLogoFolderPath;
import static com.nagp.contants.FrameworkConstants.getCurrentTestResultPath;
import static com.nagp.contants.FrameworkConstants.getLogoFolderPath;
import static com.nagp.utils.TestResultUtils.moveFoldersContents;
import static com.nagp.utils.TestResultUtils.setExtentReportLocation;
import static io.appium.java_client.service.local.AppiumDriverLocalService.buildDefaultService;
import static java.awt.Desktop.getDesktop;

import com.nagp.factory.FileFactory;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
    features = {"src/test/java/com/nagp/features"},
    glue = {"com.nagp.steps"},
    tags = "@regression",
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:test-output/FailedScenarios.txt"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

  AppiumDriverLocalService service;

  @BeforeSuite
  public void startServer() {
    setExtentReportLocation();
    service = buildDefaultService();
    service.start();
    moveFoldersContents(getCurrentTestResultPath(), getArchivedTestResultPath());
    moveFoldersContents(getLogoFolderPath() + getCurrentLogoFolderPath(),
        getArchivedLogoFolderPath());
  }

  @AfterSuite
  public void stopServer() throws IOException {
    FileFactory.removeExtraFileInLogs();
    service.stop();
    getDesktop().browse(new File(getCurrentExtentReportPath()).toURI());
  }

}
