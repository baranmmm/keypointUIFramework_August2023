@applications
Feature: Dashboard Profile Feature

  Scenario: As a super admin User, I should be able to verify that the  Profile Name, Status Role, Log Out  are visible
    Given the user logs in as "superadmin"
    Then verify the Status Role is visible
    And verify the Profile Name is visible
    Given the user clicks on the profile name
    Then verify the Log Out is visible
    And verify the Log Out items is clickable
