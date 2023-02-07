Feature: Login Functionality

Scenario: Login with valid credentials
Given User navigates to Login page
When User enters valid email address "varalakshmi.kurri@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should logeed in successfully

Scenario: Login with invalid credentials
Given User navigates to Login page
When User enters invalid email address into email field
And User enters invalid password "vara123" into password field
And User clicks on Login button
Then User should not logged in successfully
And User should get proper login error message as "Userid and password does not match"

Scenario: Login without providing any credentials
Given User navigates to Login page
When User clicks on Login button
Then User should not logged in successfully
And User should get proper login error message as "Please enter Userid and Password"

