Feature: Is the login function working correctly?
  Login function must work correctly and meet the requirements

  Scenario: UC-1 Test Login form with empty credentials
    Given Login page is opened
    When Enter username as "login_empty" and password as "password_empty"
    And Clear the username inputs
    And Clear the password input
    And Hit the Login button
    Then I should receive message "Username is required"

  Scenario: UC-2 Test Login form with credentials by passing Username
    Given Login page is opened
    When Enter username as "login_empty" and password as "password_empty"
    And Clear the password input
    And Hit the Login button
    Then I should receive message "Password is required"

  Scenario: UC-3 Test Login form with credentials by passing Username & Password
    Given Login page is opened
    When Enter username as "<accepted username>" and password as "secret_sauce"
    And Hit the Login button
    Then Page title should be "Swag Labs"