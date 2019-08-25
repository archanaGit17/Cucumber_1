Feature: Validate the facebook site
Scenario: Validate login details
Given User is on facebook page
When User enters crendentials and click the login button
Then Verify url contains login_attempt
