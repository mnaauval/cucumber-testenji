#Author: mnaauval@gmail.com
Feature: Login to Cicool Dashboard

  Scenario: Login with valid credentials
    Given User at Login page
    When User input usernamevalid as "mnaauval@gmail.com"
    And User input passwordvalid as "admin123"
    And User click login button
    Then User login to Dashboard page

  Scenario Outline: Login with not valid credentials
    Given User at Login page
    When User input username <username>
    And User input password <password>
    And User click login button
    Then Login page show error message

    Examples: 
      | username             | password |
      | mnaauval@gmail.com   | admin789 |
      | mnaauval20@gmail.com | admin123 |
      |                      |          |
