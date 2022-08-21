Feature: This Page Validates the feature of Look Closer Page

  @regression
  Scenario: Verify the Initial Text on Fresh Start Page

    Given User logs in as "Pragya" if not already logged in
    Then User clicks on dropdown to add Mentee
    Then User enters "Jonah" of the Mentee
    Then User clicks on submit button
    Then User clicks on "Look Closer" bucket on Home Page
    Then User clicks on "1. Fresh Start" bar on Look Closer Page
    Then Fresh Start Page should have following text
    """
    The aim of this session is to start to think about our existing perceptions of Jesus and consider how he can bring transformation.
    """
