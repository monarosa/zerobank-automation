@Regression
Feature: login to the application.

  when user logs in with valid credentials, Account summary page should be displayed.
  Users with wrong username or wrong password should not be able to login. Users
  with blank username or password should also not be able to login. When user tries
  to login with invalid information, error message Login and/or password are wrong.
  should be displayed.
  Background:
    Given the user is on the home page
    And the user clicks on login button

  @Smoke @Functional
  Scenario: logs in with valid credentials
    Given user log in with username "username" and password "password"
    Then  "Account Summary" page is displayed
  @Smoke
  Scenario: log in attempt with incorrect username
    Given user log in with username "wrongUserName" and password "password"
    Then  "Account Summary" page is not displayed
    Then  error message "Login and/or password are wrong." is displayed

  @Smoke
  Scenario: log in attempt with incorrect password
    Given user log in with username "username" and password "wrongpassword"
    Then  "Account Summary" page is not displayed
    Then  error message "Login and/or password are wrong." is displayed
  @Smoke
  Scenario: log in attempt with blank username
    Given user log in with username "" and password "password"
    Then  "Account Summary" page is not displayed
    Then  error message "Login and/or password are wrong." is displayed
  @Smoke
  Scenario: Scenario: log in attempt with blank password
    Given user log in with username "username" and password ""
    Then  "Account Summary" page is not displayed
    Then  error message "Login and/or password are wrong." is displayed