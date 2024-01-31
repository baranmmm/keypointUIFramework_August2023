@applications
Feature: Dashboard Profile Feature

  Background:
    Given the user logs in as "superadmin"

  Scenario: As a super admin User, I should be able to verify that the  Profile Name, Status Role, Log Out  are visible
    Then verify the Status Role is visible
    And verify the Profile Name is visible
    Given the user clicks on the profile name
    Then verify the Log Out is visible
    And verify the Log Out items is clickable

  Scenario: As Super admin User, I should be able to verify that the headers and Subtitles in dashboard page are visible
    Then verify the "Dashboard" is visible
    Then verify the "Registered Candidates" title is visible
    Then verify the "Total Applications" title is visible
    Then verify the "Total Posted Jobs" title is visible

  Scenario: As Super admin User, I should be able to verify when a new job is created , "Total Posted Jobs" should be updated automatically.
    Given get the "Total Posted Jobs"
    And click on the "Activity"
    * click on the "Jobs"
    * click on the "Create Jobs"
    * clicks on the "+" symbol
    * enter the required information into the form
    * click on the create button
    * click on the "Dashboard"
    Then verify that "Total Posted Jobs" increased by 1

  Scenario: As Super admin User, I should be able to verify "Browse applicants list" headings should be visible.
    Then verify the Browse applicants list is visible

  Scenario: As Super admin User, I should be able to verify Candidate Info,Company Name, Applied Position,Applied Date ,Closing Job Date,Job Details,Status should be visible and functional
    Then Verify the "CANDIDATE INFO" is visible
    Then Verify the "COMPANY NAME" is visible
    Then Verify the "APPLIED POSITION" is visible
    Then Verify the "APPLIED DATE" is visible
    Then Verify the "CLOSING JOB DATE" is visible
    Then Verify the "JOB DETAILS" is visible
    Then Verify the "STATUS" is visible

    Scenario: As Super Admin user, I should be able to verify that when the three dots (: under the candidate info) is clicked,relative page should be open.
      When user clicks on the three dots (under the candidate info)
      Then user verifies that the relevant "Job Details" page has been opened