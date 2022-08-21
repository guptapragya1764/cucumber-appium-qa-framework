package com.nagp.pages;

import static com.nagp.enums.LocatorType.ACCESSIBILITYID;
import static com.nagp.enums.LocatorType.XPATH;
import static com.nagp.utils.TestResultUtils.waitTill;
import static java.lang.String.format;

import java.util.List;

public class PassItOnPage extends BasePage {

  private String title_page = "//android.widget.TextView[@text='%s' and @index='1']";
  private String subSections = "//android.widget.ScrollView//android.widget.ImageView/preceding-sibling::android.widget.TextView";
  private String elementWithTextAttribute = "//*[@text=\"%s\"]";
  private String icon_Calendar = "//android.widget.ScrollView//android.widget.ImageView[@index='1']";

  public boolean checkPageTitle(String title) {
    return checkIfElementExist(XPATH, format(title_page, title), "Page title of " + title);
  }

  public List<String> getAllSubSections() {
    return getTextFromElements(XPATH, subSections, "All the Subsection");
  }

  public PassItOnPage clickOnElementWithTextAttribute(String textValue, String elementName) {
    click(XPATH, format(elementWithTextAttribute, textValue), elementName);
    return this;
  }

  public PassItOnPage horizontalSwipe(int numberOfTimes) {
    swipeRightXTimes(0.5, 0.2, 0.5, "Call Page", numberOfTimes);
    return this;
  }

  public PassItOnPage clickOnCalendarIcon() {
    click(XPATH, icon_Calendar, "Calendar Icon");
    return this;
  }

  public PassItOnPage selectHour(String currentHour, String requiredHour) {
    swipeByElement(ACCESSIBILITYID, currentHour, requiredHour, "Hour " + currentHour,
        "Hour " + requiredHour);
    waitTill(2);
    return this;
  }
}
