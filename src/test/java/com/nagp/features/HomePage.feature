Feature: This page verifies the feature of Homepage

  Background:
    Given User logs in as "Pragya" if not already logged in

  @smoke @regression
  Scenario Outline: User should be able to add multiple Mentee on Home Page
    Then User clicks on dropdown to add Mentee
    Then User enters "<firstName>" of the Mentee
    Then User clicks on submit button
    Then All the "<firstName>" should be added as Mentee
    Examples:
      | firstName |
      | John      |
      | James     |
      | David     |


  @regression
  Scenario: Validate the Sub heading and Sub text of each bucket on Home Page
    Then Following bucket should have correct corresponding subheading and sub text
      | BucketName     | SubHeading                | SubText                |
      | Come Alive!    | Discovering who I am      | searching, questioning |
      | Look Closer    | Exploring who Jesus is    | searching, questioning |
      | New Beginnings | I've become a Christian   | committed, growing     |
      | Step Out       | Joining God's Mission     | maturing, influencing  |
      | Pass it On     | Becoming a Disciple Maker | maturing, influencing  |

  @sanity @regression
  Scenario: User should be able to reach on 'Pass it On' Page
    Then User clicks on "Pass it On" bucket on Home Page
    Then User should be on "Pass it On" Page

