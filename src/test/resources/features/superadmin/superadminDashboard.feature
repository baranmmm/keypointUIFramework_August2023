@applications
Feature: Dashboard Profile Feature

  Background:
    Given the user logs in as "superadmin"

  Scenario: TC-1 As a super admin User, I should be able to verify that the  Profile Name, Status Role, Log Out  are visible
    Then verify the Status Role is visible
    And verify the Profile Name is visible
    Given the user clicks on the profile name
    Then verify the Log Out is visible
    And verify the Log Out items is clickable

  Scenario: TC-2 As Super admin User, I should be able to verify that the headers and Subtitles in dashboard page are visible
    Then verify the "Dashboard" is visible
    Then verify the "Registered Candidates" title is visible
    Then verify the "Total Applications" title is visible
    Then verify the "Total Posted Jobs" title is visible

  @TC-3
  Scenario Outline: TC-3 As Super admin User, I should be able to verify when a new Candidate is creted, the total number of "Candidate Registered" should automatically update
    Given the user get the "Registered Candidates"
    And the user logs out from talrise
    * the user clicks "SIGN UP" link
    And the User enters valid "<First Name>","<Last Name>","<Password>","<Confirm Password>"
    And the user clicks on checkbox that I have read and agree to the privacy policy and GDPR.
    And the clicks on button that CREATE MY ACCOUNT button
    Then the user should be able to see Registered successfully! message
    And the user Confirm Email and registered candidates
    Then the user verify that "Registered Candidates" increased by 1
    Examples:
      | First Name | Last Name | Password    | Confirm Password |
      | Meltem     | CG        | Test123456! | Test123456!      |

  Scenario: TC-5 As Super admin User, I should be able to verify when a new job is created , "Total Posted Jobs" should be updated automatically.
    Given get the "Total Posted Jobs"
    And click on the "Activity"
    * click on the "Jobs"
    * click on the "Create Jobs"
    * clicks on the "+" symbol
    * enter the required information into the form
    * click on the create button
    * click on the "Dashboard"
    Then verify that "Total Posted Jobs" increased by 1

  Scenario: TC-6 As Super admin User, I should be able to verify "Browse applicants list" headings should be visible.
    Then verify the Browse applicants list is visible

  Scenario: TC-8 As Super admin User, I should be able to verify Candidate Info,Company Name, Applied Position,Applied Date ,Closing Job Date,Job Details,Status should be visible and functional
    Then Verify the "CANDIDATE INFO" is visible
    Then Verify the "COMPANY NAME" is visible
    Then Verify the "APPLIED POSITION" is visible
    Then Verify the "APPLIED DATE" is visible
    Then Verify the "CLOSING JOB DATE" is visible
    Then Verify the "JOB DETAILS" is visible
    Then Verify the "STATUS" is visible

  Scenario: TC-9 As Super Admin user, I should be able to verify that when the three dots (: under the candidate info) is clicked,relative page should be open.
    When user clicks on the three dots (under the candidate info)
    Then user verifies that the relevant "Contact Details" page opened

  Scenario: TC-10 As Super Admin user, I should be able to verify that when the three dots (: under the job details) is clicked,relative page should be open.
    When user clicks on the three dots (under the job details)
    Then user verifies that the relevant "Job Details" page has been opened

  Scenario: TC-12 As Super Admin user, I should be able to verify that the filter size of the table (under the Browse applicants list) should be functional.(It can be select 5 rows)
    When user clicks on the rows
    And  user selects 5
    Then verify the size is "5 rows"

  Scenario: TC-13 As Super Admin user, I should be able to verify that the filter size of the table (under the Browse applicants list) should be functional.(It can be select 10 rows)
    When user clicks on the rows
    And  user selects 10
    Then verify the size is "10 rows"

  Scenario: TC-14 As Super Admin user, I should be able to verify that the filter size of the table (under the Browse applicants list) should be functional.(It can be select 20 rows)
    When user clicks on the rows
    And  user selects 20
    Then verify the size is "20 rows"

  Scenario: TC-15 As Super Admin user, I should be able to verify that Next Page(>) should be functional
    When user clicks on the rows
    And  user selects 5
    * user clicks on the "Next Page" arrow button
    Then user verify page size is bigger than 5 (6-10 )

  Scenario: TC-16 As Super Admin user, I should be able to verify that Last Page (>|) should be functional
    When user clicks on the rows
    And  user selects 5
    * user clicks on the "Last Page" arrow button
    Then user verify the "Next Page" (>) is not clickable

  Scenario: TC-17 As Super Admin user, I should be able to verify that First Page( >) should be functional
    When user clicks on the rows
    And  user selects 5
    * user clicks on the "Last Page" arrow button
    * user clicks on the "First Page" arrow button
    Then user verify the page size is "1-5"

  Scenario: TC-18 As Super Admin user, I should be able to verify that Previous Page (<) should be functional
    When user clicks on the rows
    And  user selects 5
    * user clicks on the "Next Page" arrow button
    * user clicks on the "Previous Page" arrow button
    Then user verify the page size is "1-5"

  Scenario: TC-19 As Super Admin user, I should be able to verify that "CREATE A NEW JOB" button should be functional
    Given user clicks on the "CREATE A NEW JOB" button
    Then user verify that relevant page open

  @TC-20-Dashboard
  Scenario: TC-4 As a super admin User, I should be able to verify when a new application is added, the "Total Applications" should be updated automatically.
    And "Total Applications" number is retrieved
    * the user logs out from talrise
    * the user logs in as "candidate"
    * the user clicks on the "Activity"
    * the user clicks on the "Jobs"
    * the user clicks on the plus item of the second Job under the "VIEW|APPLY"
    * the user logs out from talrise
    * the user logs in as "superadmin"
    Then the user verify the "Total Applications" increased 1
    And the user logs out from talrise
    * the user logs in as "candidate"
    * the user clicks on the "Activity"
    * the user clicks on the "Applied Jobs"
    * the user clicks on the three dot item of the first Job under DETAILS
    * the user clicks on the "WITHDRAW" button
    And the user logs out from talrise
    * the user logs in as "superadmin"
    Then the user verify the "Total Applications" decreased -1

  Scenario Outline:  TC-20 As Super Admin user, I should be able to verify that
    When the user clicks on "<Column Name>" in "<Column>"
    Then the user verifies that the "<Column>" is sorted ascending
    When the user clicks on "<Column Name>" in "<Column>"
    Then the user verifies that the "<Column>" is sorted descending
    When the user clicks on "<Column Name>" in "<Column>"
    Then the user verifies that the "<Column>" is sorted descending by id
    Examples:
      | Column Name      | Column |
      | COMPANY NAME     | 2      |
      | APPLIED POSITION | 3      |
   #  | APPLIED DATE     | 4      |
    # | CLOSING JOB DATE | 5      |
    #  | JOB DETAILS      | 6      |
    #  | STATUS           | 7      |