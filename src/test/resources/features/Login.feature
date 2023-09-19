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
      | ali@example.com        | Aliraza.10 |

  Scenario Outline: Job Application
    Given User is on job search page, logged in and enters valid '<jobTitle>' and '<location>'
    When User clicks a job link, the user should be taken to job page
    Then User clicks Apply now
    And User uploads CV
    Examples:
      | jobTitle    | location |
      | QA Engineer | America  |
      | abc         | xyz      |