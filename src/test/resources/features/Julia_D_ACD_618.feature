#exercise for ASK application
#Author: Julia Demchenko

@multi_choice
Feature: Multi-choice Options

  @multi_choice1
  Scenario:User is unable to add more than 15 options
    Given JD I open URL "http://ask-internship.portnov.com/#/login"
    Then JD type "julsontester@gmail.com" as Email Address
    And JD type "741852" as Password
    And JD I click on "Sign In" button
    Then JD wait for 2 seconds
    Then JD I click on "Quizzes" menu item
    Then JD wait for 2 seconds
    Then JD click on the "Create New Quiz" button
    Then JD wait for 1 seconds
    Then JD I type "My Quiz1" for Quiz Title
    Then JD I add a question
    Then JD pick "Multiple-Choice" question type
    Then JD wait for 2 seconds
    Then JD I click on the Add Option button several times
    Then JD wait for 5 seconds
