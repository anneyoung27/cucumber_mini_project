Feature: Registration functionality

  Background:
    Given User navigates to login page
    And User clicks on continue button to register new account

  Scenario: User creates an account only with mandatory fields
    When User enters the details into below fields
      | firstName | Injas                  |
      | lastName  | Mahendra               |
      | email     | mahendraqa27@gmail.com |
      | password  | 12345                  |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully


  Scenario: User creates an account with all fields
    When User enters the details into below fields
      | firstName | Injas                  |
      | lastName  | Mahendra               |
      | email     | mahendraqa27@gmail.com |
      | password  | 12345                  |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates an account with duplicate account
    When User enters the details into below fields
      | firstName | Injas                  |
      | lastName  | Mahendra               |
      | email     | mahendraqa27@gmail.com |
      | password  | 12345                  |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get a proper warning about duplicate email

  Scenario: User creates an account without filling any details
    When User don't enter any details into field
    And User clicks on Continue button
    Then User should get proper warning messages for every mandatory field