Feature: Login Functionality

  As a registered user at eFinancialCareers
  User tries to login
  Using a valid and invalid email ID

  Scenario Outline: Login
    Given User is on the SignIn page of eFinancialCareers
    When User enters '<email>' and '<password>'
    Then User should be logged in

    Examples:
      | email                  | password   |
      | aliomessi.19@gmail.com | Aliraza.10 |
      | ali@example.com        | Aliraza.10 |