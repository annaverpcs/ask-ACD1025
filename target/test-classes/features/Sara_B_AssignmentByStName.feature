#ASK Application
  #Author Sara Bhat
  @assignmentbystname
  Feature:  Ask Application
    @assignmentbystname1
    Scenario: Assignment assigned to one student
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
      #I used quiz name 1014 quiz. not good approach
      And  SB click on Quiz to assign
      # I used student name Jon Snow
      Then SB click one student from the list
      Then SB wait for 1 sec
      Then SB click on the button Give Assignment
      Then SB click on Home on the side panel
      And SB click on Go To Assignments
      # need to check assignment is assigned to the student.
      And SB Check to see the quiz is assigned to the student












