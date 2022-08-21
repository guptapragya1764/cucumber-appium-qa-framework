package com.nagp.pages;

import static com.nagp.contants.FrameworkConstants.getExplicitWait;
import static com.nagp.contants.FrameworkConstants.getSwipeWait;
import static com.nagp.driver.DriverManager.getDriver;
import static com.nagp.factory.LoggerFactory.info;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.toList;

import com.nagp.enums.LocatorType;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


  public void explicitWait(WebElement element) {
    WebDriverWait wait = new WebDriverWait(getDriver(), getExplicitWait());
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }


  public WebElement getElement(LocatorType locatorType, String locatorValue) {
    WebElement element = null;
    switch (locatorType) {
      case XPATH:
        element = getDriver().findElementByXPath(locatorValue);
        break;
      case ACCESSIBILITYID:
        element = getDriver().findElementByAccessibilityId(locatorValue);
        break;
      case ID:
        element = getDriver().findElementById(locatorValue);
        break;
      case NAME:
        element = getDriver().findElementByName(locatorValue);
        break;
      case CSSSELECTOR:
        element = getDriver().findElementByCssSelector(locatorValue);
        break;
      case CLASSNAME:
        element = getDriver().findElementByClassName(locatorValue);
        break;
    }
    explicitWait(element);
    return element;
  }

  public List<WebElement> getElements(LocatorType locatorType, String locatorValue) {
    List elements = null;
    switch (locatorType) {
      case XPATH:
        elements = getDriver().findElementsByXPath(locatorValue);
        break;
      case ACCESSIBILITYID:
        elements = getDriver().findElementsByAccessibilityId(locatorValue);
        break;
      case ID:
        elements = getDriver().findElementsById(locatorValue);
        break;
      case NAME:
        elements = getDriver().findElementsByName(locatorValue);
        break;
      case CSSSELECTOR:
        elements = getDriver().findElementsByCssSelector(locatorValue);
        break;
      case CLASSNAME:
        elements = getDriver().findElementsByClassName(locatorValue);
        break;
    }
    return elements;
  }

  private void click(WebElement element, String elementName) {
    element.click();
    info(elementName + " is clicked successfully");
  }

  protected void click(LocatorType locatorType, String locatorValue, String elementName) {
    click(getElement(locatorType, locatorValue), elementName);
  }


  protected boolean checkIfElementExist(LocatorType locatorType, String locatorValue,
      String elementName) {
    boolean flag = getElements(locatorType, locatorValue).isEmpty();
    if (flag) {
      info(elementName + " does not exist");
    } else {
      info(elementName + " exists");
    }
    return !flag;
  }

  private void sendKeys(WebElement element, String value, String elementName) {
    element.sendKeys(value);
    info("Data entered in " + elementName + " successfully");
  }

  protected void sendKeys(LocatorType locatorType, String locatorValue, String elementValue,
      String elementName) {
    sendKeys(getElement(locatorType, locatorValue), elementValue, elementName);
  }

  protected List<String> getTextFromElements(LocatorType locatorType, String locatorValue,
      String elementName) {
    List<String> textOfElements = getElements(locatorType, locatorValue).stream()
        .map(WebElement::getText).collect(toList());
    info("Text Of element" + elementName + " retrieved");
    return textOfElements;
  }

  private void swipeRightByCoordinates(double startPercentage,
      double endPercentage, double centerPercentage, String elementName) {
    Dimension dimensions = getDriver().manage().window().getSize();
    double screenWidthStart = (dimensions.getWidth() * startPercentage);
    int scrollStart = (int) screenWidthStart;
    double screenHeightEnd = (dimensions.getWidth() * endPercentage);
    int scrollEnd = (int) screenHeightEnd;
    int center = (int) (dimensions.height * centerPercentage);
    swipeByCoordinates(scrollStart, scrollEnd, center, center);
  }

  protected void swipeRightXTimes(double startPercentage, double endPercentage,
      double centerPercentage, String elementName, int numberOfTimes) {
    int i = 1;
    while (i <= numberOfTimes) {
      swipeRightByCoordinates(startPercentage, endPercentage, centerPercentage, elementName);
      i++;
    }
  }

  private void swipeByCoordinates(int scrollStartX, int scrollEndX, int scrollStartY,
      int scrollEndY) {
    new AndroidTouchAction(getDriver()).press(point(scrollStartX, scrollStartY))
        .waitAction(waitOptions(ofSeconds(getSwipeWait()))).
        moveTo(point(scrollEndX, scrollEndY)).release().perform();
    info("Swipe By Coordinates has performed");
  }

  public void swipeByElement(LocatorType locatorType, String sourceLocatorValue,
      String targetLocatorValue, String element1, String element2) {
    new AndroidTouchAction(getDriver()).longPress(
            longPressOptions().withElement(element(getElement(locatorType, sourceLocatorValue))))
        .waitAction(WaitOptions.waitOptions(ofSeconds(getSwipeWait())))
        .moveTo(element(getElement(locatorType, targetLocatorValue)))
        .release()
        .perform();
    info("Swipe from " + element1 + " to " + element2 + " is performed");
  }

  protected void scrollToElementVertically(String bucketName, String elementName,
      boolean clickRequired) {
    WebElement element = getDriver().findElementByAndroidUIAutomator(
        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + bucketName + "\"))");
    if (clickRequired) {
      click(element, elementName);
    }
    info("Scrolled to " + elementName);
  }
}