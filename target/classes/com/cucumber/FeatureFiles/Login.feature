Feature: Free CRM 

Scenario: Check Login Functionality 

	Given User hits URL. 
	When User enter valid UserId and Password 
	Then Home page is displayed. 
	
Scenario: Check LogOut Functionality 

	Given User hits URL. 
	When User enter valid UserId and Password 
	Then User click on Logout button