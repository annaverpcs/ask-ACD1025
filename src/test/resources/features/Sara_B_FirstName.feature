#Ask project
  #Author: Sara Bhat
  #internal Internship

@Firstname
Feature:  Ask Application
  Background:
    Given SB navigate to "internship page"
    Then SB click on "Register Now" button
    Then SB should see "Assessment Control @ Portnov" page
    And SB should see the form Registration

  @Firstname1
  Scenario: firstname field is empty
    Then SB click "Register Me" button
    Then SB should see error message "This field is required"
  @Firstname2
  Scenario:  firstname field has only english alphabets
    And SB click "firstName" field
    And SB type "Sara" in the first name filed
    Then SB click on LastName field
    And SB wait for 1 sec
    Then error message field should not be displayed
  @Firstname3
  Scenario:  Firstname field contains space in the name
    And SB type "Sara Bhat" in the first name filed
    Then SB click on LastName field
    Then error message should  be displayed
  @Firstname4
  Scenario: Firstname field alphanumeric value
    And SB type "Sara2" in the first name filed
    Then SB click on LastName field
    And SB wait for 1 sec
    Then error message should not be displayed













