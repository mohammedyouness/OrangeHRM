Feature:  Admin functionality testing
  Background:
    Given User launches the OrangeHRM
  @e2eTest
  Scenario: Add and delete a new user
    Given User is on OrangeHRM login page
    When User enters "Admin" as username
    And User enters "admin123" as password
    And User clicks on the login button
    And User clicks on the Admin tab on the left side menu
    And User gets the number of records found
    And User clicks on the add button
    And User fills the required data
    And User clicks on the save button
    Then Verify that the number of records increased by 1
    And User searches with the username for the new user
    And User deletes the new user
    Then Verify that the number of records decreased by 1