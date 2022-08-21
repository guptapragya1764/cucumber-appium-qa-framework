package com.nagp.pages;

import static com.nagp.contants.MessageConstants.ERROR_MESSAGE_FOR_SUBHEADER;
import static com.nagp.contants.MessageConstants.ERROR_MESSAGE_FOR_SUBTEXT;
import static com.nagp.enums.LocatorType.XPATH;
import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public final class HomePage extends BasePage {

  private final String txtbox_username = "//android.widget.EditText[@index='4']";
  private final String btn_continue = "//android.widget.TextView[@text='Continue']";
  private final String drodown_AddMentee = "//android.widget.ImageView[@index='2']";
  private final String label_AddMentee = "//android.widget.TextView[@text='Add a mentee']";
  private final String txtbox_menteeFirstName = "//android.widget.EditText[@index='1']";
  private final String btn_Submit = "//android.widget.TextView[@text='Submit']";
  private String label_selectedMenteeName = "//android.widget.TextView[@text='%s' and @index='2']";
  private String label_subheading = "//*[@text=\"%s\"]/parent::android.view.ViewGroup/*[@index='1']";
  private String label_subText = "//*[@text=\"%s\"]/parent::android.view.ViewGroup/*[@index='3']";

  public HomePage enterUsernameInfield(String username) {
    sendKeys(XPATH, txtbox_username, username, "Username field");
    return this;
  }

  public HomePage clickOnContinueButton() {
    click(XPATH, btn_continue, "Continue Button");
    return this;
  }

  public boolean checkIfLoginPageAppears() {
    return checkIfElementExist(XPATH, txtbox_username, "Username text field");
  }

  public HomePage clickOnDropdownAddMentee() {
    click(XPATH, drodown_AddMentee, "Add Mentee Dropdown");
    return this;
  }

  public boolean checkIfAddMenteeLabelAppears() {
    return checkIfElementExist(XPATH, label_AddMentee, "Add Mentee Lablel");
  }

  public HomePage enterFirstNameInfield(String firstName) {
    sendKeys(XPATH, txtbox_menteeFirstName, firstName, "First Name field");
    return this;
  }

  public HomePage clickOnSubmitButton() {
    click(XPATH, btn_Submit, "Submit Button");
    return this;
  }

  public boolean checkIfMenteeExist(String firstName) {
    return checkIfElementExist(XPATH, format(label_selectedMenteeName, firstName),
        "Dropdown value");
  }

  public void clickOnBucket(String bucketName) {
    scrollToElementVertically(bucketName, bucketName + " bucket", true);

  }

  public void checkSubHeaderAndSubText(String bucketName, String expectedSubHeadingValue,
      String expectedSubTextValue) {
    scrollToElementVertically(bucketName, bucketName, false);
    assertEquals(expectedSubHeadingValue,
        getElement(XPATH, format(label_subheading, bucketName)).getAttribute(
            "text"), format(ERROR_MESSAGE_FOR_SUBHEADER, expectedSubHeadingValue, bucketName));
    assertEquals(expectedSubTextValue,
        getElement(XPATH, format(label_subText, bucketName)).getAttribute("text"),
        format(ERROR_MESSAGE_FOR_SUBTEXT, expectedSubTextValue, bucketName));

  }
}
