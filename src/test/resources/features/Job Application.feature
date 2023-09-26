Feature: Job Application Process

  This feature represents the complete job application process on our platform,
  providing users with a seamless experience when applying for job openings.
  It streamlines the steps from searching for a job to completing the application,
  ensuring a hassle-free and efficient workflow.

  Scenario Outline: Job Application for QA Engineer
    Given User is on job search page, logged in and enters valid '<jobTitle>' and '<location>'
    When User clicks a job link, the user should be taken to job page
    Then User clicks Apply now
    And User uploads CV
    Then User completes the application process

    Examples:
      | jobTitle    | location |
      | QA Engineer | America  |
      | abc         | xyz      |