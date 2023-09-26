Feature: Deleting a CV from a profile

  Scenario: Successfully deleting CV document
    Given User is logged in on eFinancialCareers
    And User is on homepage
    When User tries to delete a CV document from their profile
    Then The CV document should be deleted successfully