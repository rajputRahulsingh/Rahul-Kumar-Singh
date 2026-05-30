Feature: verify login functionality

Background:
Given page should be open in default browser

Scenario: verify login page with valid credentials
Given username and password available
When click on username field and add valid user and pass

Scenario: verify login page with valid username and invalid password
Given username and password available
When click on username field and add valid user and pass

Scenario: verify login page with invalid username and valid password
Given username and password available
When click on username field and add valid user and pass

Scenario: verify login page with invalid username and invalid password
Given username and password available
When click on username field and add valid user and pass