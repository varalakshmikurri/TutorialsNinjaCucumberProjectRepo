Feature: Search Functionality

Scenario: User searches for a valid product
Given User lands on the home page
When User enter valid product name "HP" in search box field
And User clicks on Search button
Then User should get valid product displayed on the search results page

Scenario: User searches for a invalid product
Given User lands on the home page
When User enter invalid product name "Honda" in search box field
And User clicks on Search button
Then User should get a error message about invalid product


Scenario: User searches without any product
Given User lands on the home page
When User does not enter any product name in search box field
And User clicks on Search button
Then User should get a error message about no product matching