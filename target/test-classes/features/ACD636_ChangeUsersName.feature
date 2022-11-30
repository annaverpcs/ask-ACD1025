# ACD-636 Automate test set "User's management - Teacher - Change User's Name"
  #https://jira.portnov.com/browse/ACD-636
# Author: Anastasiia Sokolova

@changUserName
Feature:


  Background: Open ASK application
    Given AS open url "http://ask-internship.portnov.com/#/login"
    Then AS check that environment is Intership

  @changUserName1
  Scenario: Login in ASK as Teacher
    Then AS element with "//mat-card[@class='login mat-card']" should be present
    Then AS login with "askteacher@mailinator.com" and "12345" as Teacher
    Then AS check role of user is "TEACHER"



