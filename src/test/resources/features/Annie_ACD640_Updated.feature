
  #Author: Annie

  Feature: ACD 640 - Registration and Log In
    Scenario: ACD 640 - New user Registration-Activation-Successful Login
      #Registration Page
      Given I open the application using the "http://ask-internship.portnov.com/#/login"
      Then I must see page title as "Assessment Control @ Portnov"
      Then I wait for few seconds
      Then I click on the Register Now button
      Then I should see the Registration Form
      Then I wait for few seconds

      #Fill in Registration form
      Then I enter "Joshua" in the first name field
      And I enter "Suka" in the last name field
      And I enter "Joshua25@mouse.comm" in the email field
      And I enter "BSPACP" in the group code field
      And I enter "12345" in the password field
      And I enter "12345" in confirm password field
      Then I click on the Register-me button
      Then I should see the Registration Confirmed Page
      Then I wait for few seconds

      #Activation
      Then I retrieve the activation code
      And I activate the account
      Then I wait for few seconds

      #Log in (Valid Credentials)
      Given I open the application using the "http://ask-internship.portnov.com/#/login"
      Then I must see page title as "Assessment Control @ Portnov"
      Then I type the email as "Joshua25@mouse.comm" and password in "12345" fields
      And I click on Sign-IN button
      Then I must be able to see the home page
      Then I wait for few seconds


    Scenario Outline: ACD 640 - Activated User - Invalid Credentials - Fails to Log In
      Given I open the application using the <url>
      Then I must see page title as <expectedTitle>
      Then I type the email as <email> and password in <password> fields
      And I click on Sign-IN button
      Then I should see the Authentication-Failed message
      Examples:
        | url                                                | expectedTitle                  | email                      | password |
        | "http://ask-internship.portnov.com/#/login" | "Assessment Control @ Portnov" | "incorrect@snailmail.comm" | "12345"  |
        | "http://ask-internship.portnov.com/#/login" | "Assessment Control @ Portnov" | "Joshua25@mouse.comm" | "22222"  |

    Scenario: ACD 640 - New user Registration-No Activation - Log In - Fails to Log In
      #Registration
      Then I wait for few seconds
      Given I open the application using the "http://ask-internship.portnov.com/#/login"
      Then I must see page title as "Assessment Control @ Portnov"
      Then I click on the Register Now button
      Then I should see the Registration Form
      Then I enter "Alexa" in the first name field
      And I enter "Amos" in the last name field
      And I enter "Alexa25@mouse.comm" in the email field
      And I enter "BSPACP" in the group code field
      And I enter "12345" in the password field
      And I enter "12345" in confirm password field
      Then I click on the Register-me button
      Then I should see the Registration Confirmed Page
      Then I wait for few seconds

      #Log In without Activation
      Given I open the application using the "http://ask-internship.portnov.com/#/login"
      Then I must see page title as "Assessment Control @ Portnov"
      Then I type the email as "Alexa25@mouse.comm" and password in "12345" fields
      And I click on Sign-IN button
      Then I wait for few seconds
      Then I should see the Authentication-Failed message
      And I must NOT be able to see the home page





