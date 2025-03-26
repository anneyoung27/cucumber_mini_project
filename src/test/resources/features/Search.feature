Feature: Search functionality

  Background:
    Given User opens the Application

  Scenario:
    When User enters valid product "HP" into Search box field
    And User clicks on Search button
    Then User should get valid product displayed in search result

  Scenario: User search for an invalid product
    When User enters invalid product "Toyota" into Search box field
    And User clicks on Search button
    Then User should get a message about no product matching

  Scenario: User search without any product
    When User don't enter any product name into Search box field
    And User clicks on Search button
    Then User should get a message about no product matching