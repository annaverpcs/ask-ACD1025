#ASK Application
  #Author Sara Bhat
@assignmentbystname
Feature:  Ask Application
  @assignmentbystname1q

  Scenario: Assignment assigned by Student name
    Given SB navigate to "internship page"
    Then SB click on  Email  field
    And  SB enter Email "TestingMAT922@gmail.com" address
    Then SB click on password   field
    And  SB Enter password "dusty"
    Then SB click sign in  button
    Then SB should see "Assessment Control @ Portnov" page
    Then SB wait for 5 sec
    When SB click on Assignments on side menu
    Then SB Should see List of Assignments
    Then SB click on Create New Assignment button
    Then SB should see page Give Assignment
    And  SB click on Select Quiz to Assign
    And SB click on quiz name "1014 quiz"
    Then SB click student "Marina Mara" from the list
    Then SB wait for 1 sec
    Then SB click on the button Give Assignment
    Then SB click on Home on the side panel
    And SB click on Go To Assignments
    Then SB wait for 2 sec
      # need to check assignment is assigned to the student.
    And SB Check to see the quiz is assigned to the student
    Then SB wait for 2 sec
    Then SB get name field
    Then SB verify that student "Marina Mara"
    And SB get get assignment status
    And SB Verify that status is "Pending Submission" pending assignment
    And SB click button to remove assignment
    And SB remove the assignment
    And SB see pop up window
    Then SB wait for 2 sec
    And SB click on pop up window
    Then SB wait for 2 sec
    And SB click delete button
    Then SB wait for 2 sec































