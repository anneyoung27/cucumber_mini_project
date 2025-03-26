Feature: Login Functionality

  Background:
    Given User navigates to login page

  Scenario: Login with valid credentials
    When User enters valid email address "amotooricap9@gmail.com" into the email field
    And User enters valid password "12345" into the password field
    And User clicks on Login button
    Then User should get successfully logged in

  Scenario: Login with invalid credentials
    When User enters invalid email address "amotoori23@gmail.com" into email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials

  Scenario: Login with valid email and invalid password
    When User enters valid email address "amotooricap9@gmail.com" into the email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials

  Scenario: Login with invalid email and valid password
    When User enters invalid email address "amotoori23@gmail.com" into email field
    And User enters valid password "12345" into the password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials

  Scenario: Login without providing any credentials
    When User don't enter email address into email field
    And User don't enter password into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials


