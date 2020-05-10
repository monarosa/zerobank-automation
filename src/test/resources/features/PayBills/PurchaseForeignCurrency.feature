@Regression
Feature: Purchase Foreign Currency

  Background:
    Given the user is on the home page
    And the user clicks on login button
    Given the user is logged in
    And the user navigates to Pay Bills tab
  @Functional
  Scenario: Available currencies
    Given the user accesses the Purchase foreign currency cash tab
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  @fer
  Scenario: Error message for not selecting currency
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without selecting a currency
    Then error popup message "Please, ensure that you have filled all the required fields with valid values." is displayed
  @fer
  Scenario: Error message for not entering value
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without entering a value
    Then error popup message "Please, ensure that you have filled all the required fields with valid values." is displayed