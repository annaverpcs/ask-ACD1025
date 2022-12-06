# ACD-636 Automate test set "User's management - Teacher - Change User's Name"
  #https://jira.portnov.com/browse/ACD-636
# Author: Anastasiia Sokolova

@changUserName
Feature:
  @changUserName1
  Scenario: User's management - Teacher - Change User's Name
    Given AS open url "http://ask-internship.portnov.com/#/login"
    Then AS check that environment is Intership
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
    Then AS wait for 3 sec
    # Select teacher Oleg Pupkin in the list of teachers
    Then AS click on "OlegPupkin" in the teacher list
    # wait for the Teacher Profile screen
    Then AS wait for 1 sec
    And AS wait for element with "//mat-card[@class='page mat-card ng-star-inserted']" to be present
    # verify selected teacher name on the Teacher Profile screen
    Then AS verify that profile matches "OlegPupkin"
    Then AS wait for 1 sec


    @changUserName2
    Scenario Outline:
    # click on Option button on the Teacher Profile screen
    Then AS click on element with "//span[@class='mat-button-wrapper']"
    Then AS wait for 3 sec
    #Select "Change User's Name" menu item on the pop-up menu
    #Then AS click on element with "//button[contains(text(),'Name')]"
    And AS wait for element with "//mat-dialog-container" to be present

    Then AS type <sName> into New User's Name field
    # Click the button Change
    And AS check that element with "//span[contains(text(),'Change')]" is <sButtonChangeEnabled>
    Then AS click on element with "//span[contains(text(),'Change')]"
    Then AS wait for 2 sec
    Then AS verify that profile matches <sName>
    Then AS wait for 3 sec
    Examples:
    |sName           |sButtonChangeEnabled|
    |"OlgaPupkina"   |"enabled"           |
   # |"Olga Pupkina"  |"enabled"           |
   # |"A"             |"enabled"           |
   # |""              |"disabled"          |
   # |"aaaaaabbbbbcccccdddddbdhvbdkjbvkjdxvnbvjkdbvjkxnjdvbjdbqwertyuiopasdfghjklzxcvbnmhkfbsushjdvdknvjnjk"|"enabled" |
   # |"aaaaaabbbbbcccccdddddbdhvbdkjbvkjdxvnbvjkdbvjkxnjdvbjdbqwertyuiopasdfghjklzxcvbnmhkfbsushjdvdknvjnjkg"|"disabled" |
   # |"%#()"          |"enabled"           |
   # |"12354567890"   |"enabled"           |
   # |" Olga"         |"disabled"          |
   # |"Olga "         |"enabled"           |














