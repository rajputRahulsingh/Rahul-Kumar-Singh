Feature: verify login Functionality 
Scenario: verify user is to login with valid credientials
Given  login page should be open in default browse
When click on username field and add valid user username
And then click on password button and enter valid password
And now click on submit button
Then login successfully and redirect to home page