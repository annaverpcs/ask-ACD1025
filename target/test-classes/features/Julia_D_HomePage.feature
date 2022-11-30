#exercise for ASK application
#Author: Julia Demchenko

Feature: ASK application

  Scenario: Open ASK application
    Given I open URL "http://ask-internship.portnov.com/#/login"
    Then JD type "julsontester@gmail.com" as Email Address
    And JD type "741852" as Password
    And JD I click on "Sign In" button
    Then JD wait for 2 seconds
