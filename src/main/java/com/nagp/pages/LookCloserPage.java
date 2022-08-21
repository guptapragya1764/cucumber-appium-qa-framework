package com.nagp.pages;

import static com.nagp.enums.LocatorType.XPATH;
import static java.lang.String.format;

import com.nagp.enums.LocatorType;

public class LookCloserPage extends BasePage {

  private static String textInitialFocusStart = "//android.widget.TextView[@index='1']";
  private String elementWithTextAttribute = "//*[@text=\"%s\"]";

  public String getTextInitialFocusStart() {
    return getElement(LocatorType.XPATH, textInitialFocusStart).getAttribute("text");
  }

  public LookCloserPage clickOnElementWithTextAttribute(String textValue, String elementName) {
    click(XPATH, format(elementWithTextAttribute, textValue), elementName);
    return this;
  }
}
