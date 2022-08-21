Feature: This Page Validates the feature of Pass It On Page

  Background:
    Given User logs in as "Pragya" if not already logged in

  @regression @sanity
  Scenario: Validate the sub sections of Pass It On Page
    Then User clicks on "Pass it On" bucket on Home Page
    Then Following sub-sections should appear for Pass it On Page
      | 1. Call          |
      | 2. Journey       |
      | 3. Priorities    |
      | 4. Opportunities |
      | 5. Go!           |
      | 6. Fully Alive   |

  @smoke @regression
  Scenario: User should be able complete the "Call" session
    Then User clicks on dropdown to add Mentee
    Then User enters "Jonah" of the Mentee
    Then User clicks on submit button
    Then User clicks on "Pass it On" bucket on Home Page
    Then User clicks on "1. Call" bar on Pass it On Page
    Then User clicks on "Start Session" button
    Then User clicks on "Let's Go" button
    Then User perform swipe right swipe 6 times
    Then User clicks on calendar icon
    Then User clicks on "OK" button
    Then User schedules next meeting after 1 hour
    Then User clicks on "OK" button
    Then User clicks on "Finished Session" button
    Then User clicks on "Finish Review" button
