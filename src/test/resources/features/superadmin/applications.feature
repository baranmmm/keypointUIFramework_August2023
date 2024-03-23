@regression
@applications
Feature: Applications Feature

  Scenario: As a super admin User, I should be able to verify when a new application is added, the "Total Applications" should be updated automatically.
    Given the user logs in as "superadmin"
    And "Total Applications" number is retrieved
    And the user logs out from talrise
    And the user logs in as "candidate"
