# Automate End-to-End test case "Automate Student's account"
# https://jira.portnov.com/browse/ACD-639
#  Author: Emma Watt

@createStudentAccount
Feature: End-to-End test case to create a student account

  Background:
    Given I go to "Assessment Control" page

  @createStudentAccount1
  Scenario: Create a new student account
    Given I click the "Register" button
    When I input a valid data into the required fields
    And I click the Register Me button
    ######Then I am taken to the successful registration page

#    Then I get the activation token from the db for user "email"
    Then I get the activation token from the db for the user
    And I  activate the account with the token

    And I click the "Back to Login" button
    When back on the login page, I input the valid email used for registration
    And I input the valid password used for registration
    And I click the Sign In button
    Then I am signed in and redirected to the student home page


  @createStudentAccount3
  Scenario: Delete account
    Given I input a valid teacher password into the Password text field
    And I input a valid teacher email into the Email text field
    And I delete the student account
