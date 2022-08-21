package com.nagp.steps;

import static org.testng.Assert.assertEquals;

import com.nagp.contants.MessageConstants;
import com.nagp.pages.LookCloserPage;
import com.nagp.pages.PassItOnPage;
import io.cucumber.java.en.Then;
import javax.sound.midi.Soundbank;
import org.testng.Assert;

public class LookCloserSetps {

  @Then("Fresh Start Page should have following text")
  public void freshStartPageShouldHaveFollowingText(String docString) {
    assertEquals(new LookCloserPage().getTextInitialFocusStart(), docString,
        MessageConstants.ERROR_MESSAGE_FOR_TEXT_FOCUS_START);
  }

  @Then("User clicks on {string} bar on Look Closer Page")
  public void userClicksOnBarOnLookCloserPage(String menuBar) {
    new PassItOnPage().clickOnElementWithTextAttribute(menuBar, menuBar + " Menu");
  }
}
