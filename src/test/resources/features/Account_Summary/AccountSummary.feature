@Regression
Feature: Account summary

  Account summary page should have the title Zero – Account summary. Account
  summary page should have to following account types: Cash Accounts, Investment
  Accounts, Credit Accounts, Loan Accounts. Credit Accounts table must have columns
  Account, Credit Card and Balance.

  Background:
    Given the user is on the home page
    And the user clicks on login button


  Scenario: Account types
    Given the user is logged in
    Then  "Zero - Account Summary" page is displayed
    Then Account summary page should have to following account types:
      | Cash Accounts | Investment Accounts | Credit Accounts | Loan Accounts |

  @Functional
  Scenario: Credit Accounts table
    Given the user is logged in
    Then  "Zero - Account Summary" page is displayed
    Then Credit Accounts table must have columns:
      | Account | Credit Card | Balance |




