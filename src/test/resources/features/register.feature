Feature: Registration Functionality

Scenario: User creates an account with mandatory fields
Given User navigates to the Register Account page
When User enters the details into the below fields
|Firstname		|vara|
|lastname			|kurri|
|telephone		|1234567890|
|password			|12345|
And User selects Private Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to the Register Account page
When User enters the details into the below fields
|Firstname		|vara|
|lastname			|kurri|
|telephone		|1234567890|
|password			|12345|
And User selects Yes for Newsletter
And User selects Private Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates a duplicate account 
Given User navigates to the Register Account page
When User enters the duplicate details into the below fields
|Firstname		|vara|
|lastname			|kurri|
|telephone		|1234567890|
|password			|12345|
And User selects Yes for Newsletter
And User selects Private Policy
And User clicks on Continue button
Then User account should not get created
And User should get proper error message about duplicate account

Scenario: User creates an account without any filling details 
Given User navigates to the Register Account page
When User does not enter any data into fields
And User clicks on Continue button
Then User account should not get created
And User should get proper error message for each mandatory field

