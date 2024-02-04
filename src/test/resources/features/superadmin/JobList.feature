
Feature: Admin should be able to see and update the jobs list under Activity Section

  Background: :
    Given The user "superAdmin" logs in succesfully
    And The user navigates "Activity" left menu option
    And The user goes to "Jobs" option
    And The user navigates "Jobs List" option
  Scenario: TC_05 In list view, columns contents should be sort by asc/desc
