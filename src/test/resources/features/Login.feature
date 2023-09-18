Feature: Login Functionality
  In order to apply for a job at eFinancialCareers
  As a registered user
  User wants to login successfully

  Scenario Outline: Login Successful
    Given User is on the SignIn page of eFinancialCareers
    When User enters valid '<email>' and '<password>'
    Then User should be logged in
    Examples:
      | email                  | password   |
      | aliomessi.19@gmail.com | Aliraza.10 |