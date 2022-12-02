#Anastasiya Maksimenka
  @ACD-616
Feature: ACD-616 Multiple Choice Question - Text
  @ACD-616.1
  Scenario: Field accepts alphanumeric and special characters
    Given I open URL "http://ask-internship.portnov.com/"
    Then Ana wait for 2 secs
    Then Ana type "stlslam@googl.win" as Email
    Then Ana type "98765" as Password
    And Ana click on "Sign On" button
    Then Ana wait for 5 secs
    Then Ana navigate to Quizzes
    Then Ana wait for 5 secs
    Then Ana create a new Quiz
    Then Ana wait for 5 secs
    Then Ana type "Ana Quiz" as name of the quiz
    Then Ana create Multiple Choice question
    Then I validate that field allows alphanumeric and special characters

  @ACD-616.2
  Scenario: Required field
    Given I open URL "http://ask-internship.portnov.com/"
    Then Ana wait for 2 secs
    Then Ana type "stlslam@googl.win" as Email
    Then Ana type "98765" as Password
    And Ana click on "Sign On" button
    Then Ana wait for 5 secs
    Then Ana navigate to Quizzes
    Then Ana wait for 5 secs
    Then Ana create a new Quiz
    Then Ana wait for 5 secs
    Then Ana type "Ana Quiz" as name of the quiz
    Then Ana create Multiple Choice question
    Then Ana have fields empty
    Then I validate that field is required

  @ACD-616.3
  Scenario: Field accepts min 1 Character
    Given I open URL "http://ask-internship.portnov.com/"
    Then Ana wait for 2 secs
    Then Ana type "stlslam@googl.win" as Email
    Then Ana type "98765" as Password
    And Ana click on "Sign On" button
    Then Ana wait for 5 secs
    Then Ana navigate to Quizzes
    Then Ana wait for 5 secs
    Then Ana create a new Quiz
    Then Ana wait for 5 secs
    Then Ana type "Ana Quiz" as name of the quiz
    Then Ana create Multiple Choice question
    Then I validate that field allows min 1 char

  @ACD-616.4
  Scenario: Field accepts max 1000 Character
    Given I open URL "http://ask-internship.portnov.com/"
    Then Ana wait for 2 secs
    Then Ana type "stlslam@googl.win" as Email
    Then Ana type "98765" as Password
    And Ana click on "Sign On" button
    Then Ana wait for 5 secs
    Then Ana navigate to Quizzes
    Then Ana wait for 5 secs
    Then Ana create a new Quiz
    Then Ana wait for 5 secs
    Then Ana type "Ana Quiz" as name of the quiz
    Then Ana create Multiple Choice question
    Then I validate that field allows max 1000 char

  @ACD-616.5
  Scenario: Field does not accept more than 1000 Character
    Given I open URL "http://ask-internship.portnov.com/"
    Then Ana wait for 2 secs
    Then Ana type "stlslam@googl.win" as Email
    Then Ana type "98765" as Password
    And Ana click on "Sign On" button
    Then Ana wait for 5 secs
    Then Ana navigate to Quizzes
    Then Ana wait for 5 secs
    Then Ana create a new Quiz
    Then Ana wait for 5 secs
    Then Ana type "Ana Quiz" as name of the quiz
    Then Ana create Multiple Choice question
    Then I validate that field does not accept more than 1000 Character