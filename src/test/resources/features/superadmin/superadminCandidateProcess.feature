@candidateProcess
Feature: Candidate Process Feature

  Background:
    Given the user logs in as "superadmin"

  Scenario: TC-1 As a super admin User, I should be able to verify that result row number dropdown button is functional

    Given the user clicks on "Activity" button on the left hand side menu
    And the user clicks on "Candidate Process" button on the left hand side menu
    Then verify the Browse applicants list title is visible
    * verify the column of "CANDIDATE INFO" is visible
    * verify the column of "COMPANY NAME" is visible
    * verify the column of "APPLIED POSITION" is visible
    * verify the column of "APPLIED DATE" is visible
    * verify the column of "CLOSING JOB DATE" is visible
    * verify the column of "JOB DETAILS" is visible
    * verify the column of "STATUS" is visible