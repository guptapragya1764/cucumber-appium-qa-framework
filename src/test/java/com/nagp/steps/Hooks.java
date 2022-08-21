package com.nagp.steps;

import static com.nagp.driver.DriverManager.getDriver;
import static com.nagp.factory.LoggerFactory.endTestCase;
import static com.nagp.factory.LoggerFactory.startTestCase;

import com.nagp.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

  @Before
  public void setUp(Scenario scenario) {
    startTestCase(scenario.getName());
    Driver.initializeDriver();
  }

  @After
  public void tearDown(Scenario scenario) {
    endTestCase(scenario.getName(), scenario.getStatus().toString());
    Driver.quitDriver();

  }

  /**
   * Captures screenshot of the current page in case of failure, constructs a Byte string from the
   * image and return to the caller. There is no temporary screenshot image generated here.
   *
   * @return Image in the form of Byte String which can be appended directly to report
   */
  @After
  public void takeScreenShotAfterStep(Scenario scenario) {
    if (scenario.isFailed()) {
      final byte[] screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenShot, "image/jpg", scenario.getName());
    }
  }
}
