@Regression
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is on the home page
    And the user clicks on login button

  @Functional
  Scenario: Savings account redirect
    Given the user is logged in
    When the user clicks on "Savings" link on the Account Summary page
    Then "Zero - Account Activity" page is displayed
    And Account drop down should have "Savings" selected
  @Functional
  Scenario: Brokerage account redirect
    Given the user is logged in
    When the user clicks on "Brokerage" link on the Account Summary page
    Then "Zero - Account Activity" page is displayed
    And Account drop down should have "Brokerage" selected
  @Functional
  Scenario: Checking account redirect
    Given the user is logged in
    When the user clicks on "Checking" link on the Account Summary page
    Then "Zero - Account Activity" page is displayed
    And Account drop down should have "Checking" selected
  @Functional
  Scenario: Credit Card account redirect
    Given the user is logged in
    When the user clicks on "Credit card" link on the Account Summary page
    Then "Zero - Account Activity" page is displayed
    And Account drop down should have "Credit Card" selected
  @Functional
  Scenario: Loan account redirect
    Given the user is logged in
    When the user clicks on "Loan" link on the Account Summary page
    Then "Zero - Account Activity" page is displayed
    And Account drop down should have "Loan" selected