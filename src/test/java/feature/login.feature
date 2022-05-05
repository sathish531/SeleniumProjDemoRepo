Feature: Application login

Scenario: Login with valid credentials
Given Open browser
And Navigate to login page
When User entered username as "sathish12@gmail.com" and password as "12345"
And User clicked on login option
Then verify user is able to login