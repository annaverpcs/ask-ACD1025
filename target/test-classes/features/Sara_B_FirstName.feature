#Ask project
  #Author: Sara Bhat
  #internal Internship

 @Firstname
  Feature:  Ask Application
    @firstname1
    Scenario: Validate firstname
      Given SB navigate to "internship page"
      Then SB click on "Register Now" button
      Then SB should see "Assessment Control @ Portnov" page
      # empty firstname
      And SB should see the form Registration
      Then SB click "Register Me" button
      Then SB should see error message "This field is required"
      Then SB clears all the field
      # checking for valid firstname contains only English alphabets
      And SB click "firstName" field
      And SB type "Sara" in the first name filed
      Then SB click on LastName field
      And SB wait for 1 sec
      Then error message field should not be displayed
      Then SB clears all the field
      # checking for space
      And SB type "Sara Bhat" in the first name filed
      Then SB click on LastName field
      Then error message should  be displayed
      # checking for alphanumeric charecters
      Then SB clears all the field
      And SB type "Sara2" in the first name filed
      Then SB click on LastName field
      And SB wait for 1 sec
      Then error message should not be displayed











      # checking for Alphanumeric first name












