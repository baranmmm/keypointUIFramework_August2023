@regression
@profile
Feature: Profile Feature

  Background:
    Given the "candidate" logs in successfully
    And the user navigates "Profile" left menu option

  Scenario: Validate that Personal Information module is available
    Then "Personal Information" module is visible and collapsed

  Scenario: Validate that Personal Information details are opened by clicking on pencil icon
    When the user clicks on "Personal Information" section pencil icon
    Then "Personal Information" header is visible
#
#    Scenario: Validate that Personal Information details are opened by clicking on Personal Information section title
#      When the user clicks on "Personal Information" section title
#      Then "Personal Information" header is visible

  @profile1
  Scenario: All module items should be collapsed when the page first opened
    Then verify that all module items are collapsed when the page first opened

  @profile2
  Scenario: Verify that the user sees the Initials of the name in the red circle
    Then verify that the user sees the Initials of the name in the red circle

  @profile3
  Scenario: Verify that the user sees the candidate's first name, last name, job title
    Then verify that the user sees the candidate's first name, last name, job title

  @profile4
  Scenario: Location icon city name of the country should be visible on the top left side of the page
    Then Verify that the user sees the location icon and city name of the country on the top left side of the page under the first name and last name

  @profile5
  Scenario: "Off the market" text should be visible and the "Off the market" button should be visible and clickable on the top middle of the page
    Then Verify that the user sees "Off the market" text and the "Off the market" button
    Then user should click "Off the market" button

  @profile6
  Scenario: Verify that the user sees the "Profile complete rate"  text under the "Off the market" text on the top middle of the page
    Then Verify that the user sees the "Profile complete rate" text

  @profile7
  Scenario: 7: Verify that the user sees the percentage line under the "Profile complete rate"  text, with a green colour
  and it increases or decreases when the user fills profile information
  Verify that the user sees the percentage next to the percentage line
  and it increases or decreases when the user fills profile information
    Then Verify that the user sees the percentage line and rate
    When user clicks industry module
    When Select all industry field
    And user should click save button for industry fields
    Then user should see the percentage line and rate changed

  @profile8
  Scenario: 8: Verify that the user sees the percentage line under the "Profile complete rate"  text, with a green colour
  and it increases or decreases when the user deletes profile information
  Verify that the user sees the percentage next to the percentage line
  and it increases or decreases when the user deletes profile information
    When user clicks industry module
    When press the Cross button above all fields
    And user should click save button for industry fields
    Then user should see the percentage line and rate changed

  @profile9-10
  Scenario: Verify that the user sees "LAST LOGIN:" text on the top right side of the page
  Verify that the user sees the last login date and time next to the "LAST LOGIN:" text
    Then verify user should see "LAST LOGIN:" text
    Then verify user should see last login date and time

  @profile11
  Scenario: Verify that the user sees and clicks the "OVERVIEW" button on the top right corner of the page
    Then the user sees and clicks the "OVERVIEW" button

  @profile12
  Scenario: Verify that the user sees and clicks on the "Personal Information",
  "Upload CV", "Position", "Skill Set", "Industry", "Language", "Experience",
  "Education" and "Preferences" profile subtitles
    Then user sees and clicks on the Personal Information, Upload CV, Position, Skill Set, Industry, Language, Experience, Education and Preferences profile subtitles

  @profile13
  Scenario: Verify that the red cross turns green check sign when the user fills up each page
    When the user navigates to industry module
    And Select all industry field
    And user should click save button for industry fields
    Then user should see that red cross turns green check sign

  @profile14
  Scenario: Verify the green check sign turns when the user removes all industry field
    When the user navigates to industry module
    When press the Cross button above all fields
    And user should click save button for industry fields
    Then user should see that green sign turns the red cross

  @profile15
  Scenario:  Verify that the user sees and clicks the Edit icon across
  each profile subtitle and after clicking collapses the pages (form)
    When the user clicks the Edit icons
    Then the user should see the module pages opened
    When the user clicks the Edit icons for closed
    Then the user should see the module pages collapsed

