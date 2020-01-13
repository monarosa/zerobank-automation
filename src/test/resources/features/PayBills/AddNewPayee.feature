@Regression
Feature: Add new payee under pay bills

  Background:
    Given the user is on the home page
    And the user clicks on login button
    Given the user is logged in
  @Smoke @Functional
  Scenario: Add a new payee
    Given the user navigates to Pay Bills tab
    Given Add New Payee tab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    And clicks add
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed