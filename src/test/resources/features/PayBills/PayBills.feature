Feature: Bill pay operations

  Account Activity page should have the title Zero – Pay Bills. When user completes a
  successful Pay operation, The payment was successfully submitted. should be
  displayed. When user tries to make a payment without entering the amount or date,
  Please fill out this field message! should be displayed.
  Amount field should not accept alphabetical or special characters. Date field should
  not accept alphabetical characters.
  NOTE: . For the date input field you can just use sendKeys.
  No need to click on the date navigator.

  Background:
    Given the user is on the home page
    And the user clicks on login button

  @Functional
  Scenario Outline: Pay operations with no data for date and amount
    Given the user is logged in
    And the user navigates to Pay Bills tab
    Then "Zero - Pay Bills" page is displayed
    And the user selects payee "Sprint"
    And the user selects accounts "Savings"
    And the user enters the amounts "<amount>"
    And the user choose the date "<date>"
    And the user writes down description "phone bill paid from saving account"
    When the user clicks on pay button
    Then "<massage>" is displayed

    Examples:
      | amount | date       | massage                     |
      | 100    | null       | Please fill out this field. |
      | null   | 2020-03-08 | Please fill out this field. |



  Scenario: Successful bill pay operations
    Given the user is logged in
    And the user navigates to Pay Bills tab
    Then "Zero - Pay Bills" page is displayed
    And the user selects payee "Sprint"
    And the user selects accounts "Savings"
    And the user enters the amounts "100"
    And the user choose the date "2020-03-08"
    And the user writes down description "phone bill paid from saving account"
    When the user clicks on pay button
    Then Confirmation message is "The payment was successfully submitted." is displayed



  Scenario Outline: Pay operations with alphabetical or special characters
    Given the user is logged in
    And the user navigates to Pay Bills tab
    Then "Zero - Pay Bills" page is displayed
    And the user selects payee "Sprint"
    And the user selects accounts "Savings"
    And the user enters the amounts "<amount>"
    And the user choose the date "<date>"
    And the user writes down description "phone bill paid from saving account"
    When the user clicks on pay button
    Then "The payment was successfully submitted." is not displayed

    Examples:
      | amount    | date       |
      | somemoney | 2020-05-08 |
      | 100       | someday    |
      | onedollor | oneday     |