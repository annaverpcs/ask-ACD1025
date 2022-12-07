#Assignment Date ACD-197
#Author: Annie

Feature: ACD620 -Assignment Date - ACD197

  Scenario:
  Log in as a Teacher
    Given I open the ASK application "http://ask-internship.portnov.com/#/login"
    Then I type the email as "master_teacher@aol.com" and password in "12345" fields
    And I click on Sign-IN button
    Then I must see the page title as "Assessment Control @ Portnov"
    And I wait
    Then I click on Assignments from the menu
    And I wait
    And see the list of Assignments


  #ACD-210 Create Assignment to confirm Assignment Date is present
    Then I click on Create-Assignment button
    And I wait
    Then I select the Group-Filter "BSPACP"
    And I wait
    And I select the quiz name "ASK-ALP quiz"
    And I wait
    Then I select all the students
    And I wait
    And click on Give-Assignment button

      #ACD-300 Order in which Assigments are listed and #ACD-298 Check if Assignment Date is in correct format
      And I wait
      Then I check that the most recent assignment on top has the current date

     #ACD-302 Assignment Date in Detailed View
     Then I click on the topmost Assignment
     And I wait
     And I confirm that Assignment Date is present in detailed view


