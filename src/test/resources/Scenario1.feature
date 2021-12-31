Feature: Flight booking
@tag1
Scenario Outline: Flight booking

Given I am on the home page
When I click on flight
Then I should be redirected to the flight booking page
Then I should be able to enter origin "<Origin>" and "<Destination>"
Then I should be able to enter depart date "<depart date>"
Then I should be able to book flight from "<Origin>" and "<Destination>"



Examples: 
    | Origin | Destination | depart date |
    | Bengaluru | Pune | 15-12-2019 |
    | Chennai | Bengaluru | 15-01-2020 |
    
