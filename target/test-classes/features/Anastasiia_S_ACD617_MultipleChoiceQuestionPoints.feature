# ACD-617 Automate test set "Multiple Choice Question - Points
  #https://jira.portnov.com/browse/ACD-617
# Author: Anastasiia Sokolova

@quizpoints
Feature: ASK application

  Background: Open ASK application
    Given AS open url "http://ask-internship.portnov.com/#/login"
    Then AS check that environment is Intership

  @quizpoints1
  Scenario: Create a quiz and assign to a student
    Then AS element with xpath "//mat-card[@class='login mat-card']" should be present
    # Login in ASK as Teacher
    Then AS login with "askteacher@mailinator.com" and "12345" as Teacher
    Then AS wait for 2 sec
    Then AS verify role of user is "TEACHER"
    # click "Quizzes" menu item on the left navigation side menu
    Then AS click on "Quizzes" menu item
    Then AS wait for 1 sec
    # create quiz
    Then AS click on "Create New Quiz" button
    Then AS wait for 1 sec
    Then AS type "Multiple Choice Question Quiz" as Quiz Title
    #Multi-choice question 1:
    Then AS add a question
    Then AS choose "Multiple-Choice" question type
    Then AS type "Question 1" as "Question "
    Then AS type "Answer1" as "Option 1"
    Then AS type "Answer2" as "Option 2"
    Then AS click on "Add Option" button
    Then AS type "Correct answer 1" as "Option 3"
    Then AS click on "Add Option" button
    Then AS type "Correct answer 2" as "Option 4"


    Then AS click on "Save" button


  #Create 3 multi-choice type questions:

  #Multi-choice question 1:

  #Select Question Type as "Multy-Choice"
  #Set "Points per question" on 1.
  #Type the Question 1 as "Question 1"
  #Type the Option 1 as "Answer 1"
  #Type the Option 2 as "Answer 2"
  #Click the button "Add Option"
  #Type the Option 3 as "Correct answer 1"
  #Check the check-box on the left of Option 3.
  #Click the button "Add Option"
  #Type the Option 4 as "Correct answer 2"
  #Check the check-box on the left of Option 4.
  #Click the button "Add question"

  #Multi-choice question 2:

  #Select Question Type as "Multy-Choice"
  #Set "Points per question" on 5.
  #Type name of a Question 2 as "Question 2"
  #Type the Option 1 as "Answer 1"
  #Type the Option 2 as "Answer 2"
  #Click the button "Add Option"
  #Type the Option 3 as "Correct answer 1"
  #Check the check-box on the left of Option 3.
  #Click the button "Add Option"
  #Type the Option 4 as "Correct answer 2"
  #Check the check-box on the left of Option 4.
  #Click the button "Add question"
  #Multi-choice question 3:

  #Select Question Type as "Multy-Choice"
  #Set "Points per question" on 10.
  #Type name of a Question 3 as "Question 3"
  #Type the Option 1 as "Answer 1"
  #Type the Option 2 as "Correct Answer 1"
  #Check the check-box on the left of Option 2.
  #Click the button "Add Option"
  #Type the Option 3 as "Correct answer 2"
  #Check the check-box on the left of Option 3.
  #Click the button "Add Option"
  #Type the Option 4 as "Correct answer 3"
  #Check the check-box on the left of Option 4.
  #Click the button "Save"


