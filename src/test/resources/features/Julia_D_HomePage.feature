#exercise for ASK application
#Author: Julia Demchenko

@homepage
Feature: ASK application

  @homepage1
  Scenario: Create a quiz and assign to a student
    Given JD I open URL "http://ask-internship.portnov.com/#/login"
    Then JD type "julsontester@gmail.com" as Email Address
    And JD type "741852" as Password
    And JD I click on "Sign In" button
    Then JD wait for 2 seconds

  @homepage2
  Scenario:
