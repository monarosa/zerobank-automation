Feature: checking the account activities

  Account Activity page should have the title Zero – Account Activity.
  In the Account drop down default option should be Savings. Account drop down
  should have the following options: Savings, Checking, Loan, Credit Card, Brokerage.
  Transactions table should have column names Date, Description, Deposit,
  Withdrawal.

  Background:
    Given the user is on the home page
    And the user clicks on login button


  Scenario: Account activity drop down menu options
    Given the user is logged in
    And the user navigates to Account Activity tab
    Then "Zero - Account Activity" page is displayed
    Then Account drop down default option is "Savings"
    Then Account drop down has the following options:
      | Savings | Checking | Loan | Credit Card | Brokerage |


  Scenario: Account activiy Table header
    Given the user is logged in
    And the user navigates to Account Activity tab
    Then "Zero - Account Activity" page is displayed
    Then Transactions table has column names:
      | Date | Description | Deposit | Withdrawal |


