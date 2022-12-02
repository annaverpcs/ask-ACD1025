#Annie
  Feature: ASK App
    Scenario: Launch the Application
      Given I open URL "http://ask-internship.portnov.com/#/login"
      And I type "dhah@tmsave.com" as email
      And I type "Trichy75" as password
      Then I wait for 3 sec
      And I click on the Sign In button
     Then I wait for 3 sec




