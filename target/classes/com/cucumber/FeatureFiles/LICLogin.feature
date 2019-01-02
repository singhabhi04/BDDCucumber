Feature: Validation of user login to LIC Portal

@LICLogin
  Scenario Outline: Login Validation
    Given User is on LIC Login Page
    Then User Enters Username
   # Then User Enters password as "<Password>"
   Then User Enters password
    Then User Enters DOB as "<DOB>"
    And User Clicks on SignIn button
    Then User Validates UserName on Sucessfull Login
Examples:
|Username|Password|DOB|
|Singhabhi_licp|pass2@WORD|04/09/1990|

@ValidatesPolicies
Scenario: Print the Total number of policies and there number
Given User is already Logged In
Then User Clicks on Self Policies Option
Then User Validates Number of Policies.
Then User Prints the Policy Numbers of all Policies.

@LICLogOut
Scenario: Logout From Application
Given User is already Logged In
Then 	User Logged out from LIC portal


 



