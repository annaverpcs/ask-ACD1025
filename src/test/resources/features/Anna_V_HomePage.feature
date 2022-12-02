
#Exercise for ASK automation
#Author: Anna V
  @homepage
  Feature: ASK application
#comment

    @homepage1
    Scenario: Create a quiz and assign to a student
      Given AV navigate to "http://ask-internship.portnov.com/#/login"
      Then AV type "master_teacher@aol.com" as Email Address
      And AV type "12345" as Password
      And AV click on Sign In button
      Then AV wait for 1 seconds
      Then AV click on "01Quizzes" menu item
      Then AV wait for 1 seconds
      Then AV click on "Create New Quiz" button
      Then AV wait for 1 seconds
      Then AV type "Quiz Title" as Quiz Title
      Then AV add a question
      Then AV choose "Single-Choice" question type
      Then AV type "Question Title" as "Question "
      Then AV type "Answer1" as "Option 1"
      Then AV type "Answer2" as "Option 2"
      Then AV select correct 1 answer
      Then AV click on "Save" button
      Then AV wait for 2 seconds
      Then AV click on Quiz Title "01Quiz Title"
      Then AV delete Quiz "01Quiz Title"


    @homepage1
    Scenario Outline: User registration
      Given AV navigate to "http://ask-internship.portnov.com/#/registration"
      Then AV type <sFirstName> as firstname
      Then AV type <sLastName> as lastname
      Then AV type <sEmailAddress> as email
      Then AV type <sGroup> as group code
      Then AV type "12345" as Password
      Then AV type "12345" as confirm password
      And AV click on signup button
      Then AV get activation token for user <sEmail>
      And AV send activation request
      Then AV wait for 2 seconds
      Examples:
        | sFirstName | sLastName | sEmailAddress           | sGroup |  sEmail                 |
        | "John"     | "Smith"   | "jsmith3@testemail.com" | "123"  | "jsmith3@testemail.com" |
        | "John"     | "Smith"   | "jsmith4@testemail.com" | " "  | "jsmith4@testemail.com" |

