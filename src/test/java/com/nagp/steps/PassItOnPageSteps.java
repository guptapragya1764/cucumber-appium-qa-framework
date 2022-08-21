package com.nagp.steps;

import static com.nagp.contants.MessageConstants.ERROR_MESSAGE_FOR_SUBSESCTIONS;
import static com.nagp.utils.TestResultUtils.waitTill;
import static java.lang.String.format;
import static java.lang.String.valueOf;

import com.nagp.pages.PassItOnPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.time.LocalDateTime;
import java.util.List;
import org.testng.Assert;

public class PassItOnPageSteps {

  @Then("User should be on {string} Page")
  public void userShouldBeOnPage(String pageName) {
    new PassItOnPage().checkPageTitle(pageName);
  }

  @Then("Following sub-sections should appear for Pass it On Page")
  public void followingSubSectionsShouldAppearForPassItOnPage(DataTable subsections) {
    new PassItOnPage().checkPageTitle("Pass it On - 1. Call");
    List<String> actualSubsections = new PassItOnPage().getAllSubSections();
    List<String> expectedSubsections = subsections.asList();

    Assert.assertEquals(actualSubsections, expectedSubsections,
        format(ERROR_MESSAGE_FOR_SUBSESCTIONS, expectedSubsections, actualSubsections));
  }

  @Then("User clicks on {string} bar on Pass it On Page")
  public void userClicksOnBarOnPassItOnPage(String menuBar) {
    new PassItOnPage().clickOnElementWithTextAttribute(menuBar, menuBar + " Menu");
  }

  @Then("User clicks on {string} button")
  public void userClicksOnButton(String buttonName) throws InterruptedException {
    new PassItOnPage().clickOnElementWithTextAttribute(buttonName, buttonName + " button");
  }


  @Then("User schedules next meeting after {int} hour")
  public void userSchedulesNextMeetingAfterHour(int afterHour) {
    int currentHour = LocalDateTime.now().getHour();
    currentHour = currentHour > 12 ? currentHour - 12 : currentHour;
    int requiredHour = currentHour + afterHour;
    new PassItOnPage().selectHour(valueOf(currentHour), valueOf(requiredHour));
  }

  @Then("User perform swipe right swipe {int} times")
  public void userPerformSwipeRightSwipeTimes(int times) {
    waitTill(2);
    new PassItOnPage().horizontalSwipe(times);
  }

  @Then("User clicks on calendar icon")
  public void userClicksOnCalendarIcon() {
    new PassItOnPage().clickOnCalendarIcon();
  }
}
