
#Exercise for ASK automation
#Author: Anna V
  @homepage
  Feature: ASK application

    @homepage1
    Scenario: Open ASK application
      Given AV navigate to "http://ask-internship.portnov.com/#/login"

    @scenario5
    Scenario: User registration
      Given AV navigate to "http://ask-internship.portnov.com/#/registration"
      Then AV type "John" as firstname
      Then AV type "Smith" as lastname
      Then AV type "jsmith@testemail.com" as email
      Then AV type "123" as group code
      Then AV type "12345" as password
      Then AV type "12345" as confirm password
      And AV click on signup button
      Then AV get activation token for user "jsmith@testemail.com"
      And AV send activation request