#Exercise for ASK automation
#Author: Sumithra
@SubmittedAt
Feature: ASK Intenship

@SubmittedAt1
Scenario:Login as a Teacher and verifying SubmittedAt
  Given SA navigate to  "http://ask-internship.portnov.com/#/login"
  Then SA type "http://ask-internship.portnov.com/#/login" as email address
  Then SA type "12345" as password
  Then SA click on sign on Button
  Then SA wait for 5 seconds
  Then SA click on Submissions MenuItem
  Then SA click on ForGrade MenuItem
  Then SA Should see SubmittedAt
  Then SA click on AutomaticallyGraded  MenuItem
  Then SA Should see GradedAT
  Then SA click on Reviewed MenuItem
  Then SA Should see SubmittedAt
