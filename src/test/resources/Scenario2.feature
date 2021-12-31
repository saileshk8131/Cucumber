Feature: Login
@tag1
Scenario Outline: Login to AirAsia

Given I am on the home page
When I click on login
Then I should be able to enter username "<username>"
Then I should be able to enter password "<password>"
Then I should be able to click on signin
Then I should be able to login
 
       
Examples: 
     | username | password |
     | a@gmail.com | India1234 |