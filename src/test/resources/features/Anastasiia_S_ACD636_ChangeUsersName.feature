# ACD-636 Automate test set "User's management - Teacher - Change User's Name"
  #https://jira.portnov.com/browse/ACD-636
# Author: Anastasiia Sokolova

@changUserName
Feature:


  Background: Open ASK application
    Given AS open url "http://ask-internship.portnov.com/#/login"
    Then AS check that environment is Intership

  @changUserName1
  Scenario: User's management - Teacher - Change User's Name
    Then AS element with xpath "//mat-card[@class='login mat-card']" should be present
    # Login in ASK as Teacher
    Then AS login with "askteacher@mailinator.com" and "12345" as Teacher
    Then AS wait for 2 sec
    Then AS verify role of user is "TEACHER"
    # click "User's management" menu item on the left navigation side menu
    Then AS click on "Management" menu item
    Then AS wait for 1 sec
    # switch to the "Teachers" tab on the "User's Management" screen on the main frame
    Then AS switch to "Teachers" tab
    Then AS wait for 10 sec
    # Select teacher Oleg Pupkin in the list of teachers
    #Then AS click on "Oleg Pupkin" in the teacher list
    # wait for the Teacher Profile screen
    And AS wait for element with "//div[@class='container']" to be present
    # verify selected teacher name on the Teacher Profile screen
    Then AS verify that profile mutches "Oleg Pupkin"
    # click on Option button on the Teacher Profile screen
    Then AS click on element with "//span[@class='mat-button-wrapper']"

    #Select "Change User's Name" menu item on the pop-up menu





