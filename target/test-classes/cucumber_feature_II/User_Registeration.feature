Feature: User Registration
				 I want to check that the user can register in our e-commerce website 
Scenario: User Registration
Given the user in the home page 
When I click on register link
And I entered the user data "<fname>", "<lname>", "<email>", "<password>",
Then The registration page displayed successfully 

Examples:
				| fname | lname | email | password | 
				| ahmed | ashraf | ahzazahh@gmail.com | 1234567 | 
				| mohammed | ashraf | mmzazam@gmail.com | 1234567 | 