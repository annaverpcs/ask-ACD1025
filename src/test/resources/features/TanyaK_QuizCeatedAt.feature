# Automate test set "Quiz Created at"
# https://jira.portnov.com/browse/ACD-606
#  Author: Tanya Kalinina

@CreatedAt
Feature: testing Quiz Created at

  @CreatedAt1
  Scenario: Login as a teacher
    Given TK navigate to "http://ask-internship.portnov.com/#/login"
    Then TK type "gvardiaditan@gmail.com" as Email Address
    And TK type "Voznesenskaya_dom_1_120" as Password
    And TK click on Sign In button
    Then TK wait for 5 seconds
    Then TK click on "Quizzes" menu item
    Then TK wait for 1 seconds
    Then TK click on "Create New Quiz" button
    Then TK wait for 1 seconds
    Then TK type "Where we can find a Xpath?" as Quiz Title
    Then TK wait for 5 seconds
    Then TK add a question
    Then TK choose "Textual" question type
    Then TK type "How do you define Xpath? " as "Question "
    Then TK wait for 5 seconds
    Then TK click on "Save" button
    Then TK wait for 5 seconds
    Then TK click on List of Quizzes
    Then TK wait for 5 seconds
    Then TK validate created at value
