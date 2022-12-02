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
    Then JD I click on Quizzes link
    Then JD wait for 2 seconds
    #Then JD click on "Create New Quiz" button
    #Then JD wait for 2 seconds
   # Then JD I type "My Quiz1" for Quiz Title
    #Then JD I add a question
    #Then JD pick "Single-Choice" question type
    #Then JD I type "Question First" for "Question"
    #Then JD I type "Answer1" for "Option1"
    #Then JD I type "Answer2" for "Option2"
    #Then JD click on "Save" button

  @homepage2
  Scenario: User Registration as a Student
    Given JD I open URL "http://ask-internship.portnov.com/#/registration"
    Then JD I type "Larry" as First Name
    Then JD I type "Marshall" as Last NAme
    Then JD I type "student1_test@me.com" as email
    Then JD I type "007" as group code
    Then JD I type "123987" as password
    Then JD I type "123987" as confirm password
    Then JD I click on Register Me button
    Then JD I get activation code for User "student1_test@me.com"
    Then JD I send activation request
    And JD wait for 2 seconds






