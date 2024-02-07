@candidateProcess
Feature: Candidate Process Feature

  Background:
    Given the user logs in as "superadmin"

  Scenario: TC-1 As a super admin User, I should be able to verify that
    Then verify the Status Role is visible
    And verify the Profile Name is visible
    Given the user clicks on the profile name
    Then verify the Log Out is visible
    And verify the Log Out items is clicka