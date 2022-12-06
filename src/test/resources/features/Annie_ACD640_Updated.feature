
  #Author: Annie

  Feature: Registration and Log In Functionality


    Scenario Outline: ACD 640 - New user Registration-Activation-Successful Login
      #Registration Page
      Given I open the application <url>
      Then I must see page title as <expectedTitle>
      Then I click on the Register Now button
      Then I should see the Registration Form
      Then I wait for <n> seconds

      #Fill in Registration form
      Then I enter <fName> as the firstname
      And I enter <lName> as the last name
      And I enter <email> in the email field
      And I enter <groupCode> in the group code field
      And I enter <password> in the password field
      And I enter <confirmPassword> in confirm password field
      Then I click on the Register-me button
      Then I should see the message <message>
      Then I wait for <n> seconds

      #Activation
      Then I retrieve the activation code
      And I activate the account
      Then I wait for <n> seconds

      #Log in (Valid Credentials)
      Given I open the application <url>
      Then I must see the page title as <expectedTitle>
      Then I type the email as <email> and password in <password> fields
      And I click on Sign-IN button
      Then I must be able to see the home page
      Then I wait for <n> seconds
      Examples:
        | url                                         | expectedTitle                  | fName   | lName   | email               | groupCode | password | confirmPassword | message                    | n |
        | "http://ask-internship.portnov.com/#/login" | "Assessment Control @ Portnov" | "Larry" | "Style" | "Babloo4@gina.comm" | "BCBS"     | "12345"  | "12345"         | "You have been registered" | 2 |

    Scenario Outline: ACD 640 - Activated User - Invalid Credentials - Fails to Log In

      #Log In - Invalid User-name or Invalid Password
      Given I open the application <url>
      Then I must see the page title as <expectedTitle>
      Then I type the email as <email> and password in <password> fields
      And I click on Sign-IN button
      Then I should see the Authentication-Failed message

      Examples:
        | url                                         | expectedTitle                  | email               | password |
        | "http://ask-internship.portnov.com/#/login" | "Assessment Control @ Portnov" | "Babloo4@gina.comm" | "wrongpasswd"  |
        | "http://ask-internship.portnov.com/#/login" | "Assessment Control @ Portnov" | "wronguname@qina.comm" | "12345"  |

    Scenario Outline: ACD 640 - New user Registration-No Activation - Log In - Fails to Log In
      #Registration
      Then I wait for <n> seconds
      Given I open the application <url>
      Then I must see page title as <expectedTitle>
      Then I click on the Register Now button
      Then I should see the Registration Form
      Then I enter <fName> as the firstname
      And I enter <lName> as the last name
      And I enter <email> in the email field
      And I enter <groupCode> in the group code field
      And I enter <password> in the password field
      And I enter <confirmPassword> in confirm password field
      Then I click on the Register-me button
      Then I should see the message <message>
      Then I wait for <n> seconds

      #Log In without Activation
      Given I open the application <url>
      Then I must see the page title as <expectedTitle>
      Then I type the email as <email> and password in <password> fields
      And I click on Sign-IN button
      Then I should see the Authentication-Failed message
      And I must NOT be able to see the home page

      Examples:
        | url                                         | expectedTitle                  | fName   | lName   | email               | groupCode | password | confirmPassword | message                    | n |
        | "http://ask-internship.portnov.com/#/login" | "Assessment Control @ Portnov" | "Larry" | "Style" | "Babloo4@gina.comm" | "BCBS"     | "12345"  | "12345"         | "You have been registered" | 2 |






