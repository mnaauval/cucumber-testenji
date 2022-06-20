#Author: mnaauval@gmail.com
Feature: Login to Cicool Dashboard

  Scenario Outline: Login with credentials
    Given User at Login page
    When User input username <username>
    And User input password <password>
    And User click login button
    Then Login page show error message

    Examples: 
      | username             | password |
      | mnaauval@gmail.com   | admin123 |
      | mnaauval@gmail.com   | admin789 |
      | mnaauval20@gmail.com | admin123 |
      |                      |          |
