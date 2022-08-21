package com.nagp.steps;

import static org.testng.AssertJUnit.assertTrue;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.nagp.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;

public class HomePageSteps {


  @Then("User clicks on dropdown to add Mentee")
  public void userClicksOnDropdownToAddMentee() {
    new HomePage().clickOnDropdownAddMentee();
  }


  @Then("User enters {string} of the Mentee")
  public void userEntersOfTheMentee(String menteeFirstName) {
    new HomePage().enterFirstNameInfield(menteeFirstName);
  }

  @Then("User clicks on submit button")
  public void userClicksOnSubmitButton() {
    new HomePage().clickOnSubmitButton();
  }

  @Then("All the {string} should be added as Mentee")
  public void allTheShouldBeAddedAsMentee(String menteeFirstName) {
    assertTrue(new HomePage().checkIfMenteeExist(menteeFirstName));
  }

  @Then("User clicks on {string} bucket on Home Page")
  public void userClicksOnBucketOnHomePage(String bucketName) {
    new HomePage().clickOnBucket(bucketName);
  }


  @Given("User logs in as {string} if not already logged in")
  public void userLogsInAsIfNotAlreadyLoggedIn(String username) {
    ExtentCucumberAdapter.addTestStepLog("User logged in");
    HomePage homePage = new HomePage();
    if (homePage.checkIfLoginPageAppears()) {
      homePage.enterUsernameInfield(username).clickOnContinueButton();
    }
  }


  @Then("Following bucket should have correct corresponding subheading and sub text")
  public void followingBucketShouldHaveCorrectCorrespondingSubheadingAndSubText(
      DataTable dataTable) {
    List<Map<String, String>> data = dataTable.asMaps();
    data.forEach(e -> {
    new HomePage().checkSubHeaderAndSubText(e.get("BucketName"), e.get("SubHeading"), e.get("SubText"));
    });
  }
}
