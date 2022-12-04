@ACD-611/630
Feature: ACD-611/630

@ACD-611
  Scenario: Automate test set "Quiz - Updated At"
  Given IT navigate to "http://ask-internship.portnov.com/#/login"
  Then IT type "abbygeorge@unair.nl" as Email Address
  And IT type "12345" as Password
  And IT click on Sign In button
  Then IT wait for 1 seconds
  Then IT click on "Quizzes" menu item
  Then IT wait for 1 seconds
  Then IT click on "Create New Quiz" button
  Then IT wait for 1 seconds
  Then IT type "Quiz Title IT" as Quiz Title
  Then IT add a question
  Then IT choose "Single-Choice" question type
  Then IT type "Question Title" as "Question *"
  Then IT type "Answer1" as "Option 1*"
  Then IT type "Answer2" as "Option 2*"
  Then IT select correct 1 answer
  Then IT click on "Save" button
  Then IT wait for 2 seconds
  Then IT click on quiz title "Quiz Title IT"
  Then IT click on "Edit" button inside last created quiz with title "Quiz Title IT"
  Then IT wait for 2 seconds
  Then IT click on "Question Title" question
  Then IT type "1" as "Question *"
  Then IT click on "Save" button
  Then IT wait for 2 seconds
  Then IT click on quiz title "Quiz Title IT"
  Then IT compare that Created At is not equal to Updated At inside quiz with title "Quiz Title IT"
  Then IT click on "Delete" button inside last created quiz with title "Quiz Title IT"

@ACD-630
Scenario: Automate test set "Student: Settings - Full Name"
  Given IT navigate to "http://ask-internship.portnov.com/#/login"
  Then IT type "dahaha@filevino.com" as Email Address
  And IT type "11111" as Password
  And IT click on Sign In button
  Then IT wait for 1 seconds
  Then IT click on "Settings" menu item
  Then IT wait for 1 seconds
  Then IT click on "Change Your Name" button
  Then IT clear input value for "New name" field
  Then IT type in "New name" field input "1"
  Then IT alert "Should contain only latin characters" should be visible
  Then "Change" button should be disabled
  Then IT clear input value for "New name" field
  Then IT type in "New name" field input "    JamesBond    "
  Then IT alert "Should contain only latin characters" should be visible
  Then "Change" button should be disabled
  Then IT clear input value for "New name" field
  Then IT type in "New name" field input "JamesBond"
  Then IT click on "Change" button inside form
  Then IT wait for 1 seconds
  Then IT find "JamesBond" as user name


