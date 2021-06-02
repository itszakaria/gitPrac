Feature: Automation of apple web application
Description: Testing certain pages of appl website.

Scenario: 'Performance of links in apple watch page'
Given User is in apple watch page
When User tries intearactive gallery
Then He should be able to close interactive gallery



#Scenario: Performance of links in apples 'buy watch' page

Given User click on buy
When User should be able to see watch series 1
Then User should also see the 'watch series 02' page