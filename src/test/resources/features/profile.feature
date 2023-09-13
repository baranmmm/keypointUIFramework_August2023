Feature: Profile Feature
  Background:
    Given the "candidate" logs in successfully
    And the user navigates "Profile" left menu option

    Scenario: Validate that Personal Information module is available
      Then "Personal Information" module is visible and collapsed

    Scenario: Validate that Personal Information details are opened by clicking on pencil icon
      When the user clicks on pencil icon
      Then "Personal Information" header is visible

    Scenario: Validate that Personal Information details are opened by clicking on Personal Information section title
      When the user clicks on "Personal Information" section title
      Then "Personal Information" header is visible

