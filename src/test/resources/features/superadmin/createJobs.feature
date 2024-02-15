@createjobs
Feature: CreateJobs Feature
@createjbs
Scenario:
    Given Super Admin logs in as "superadmin"
    And Super Admin navigates "Activity" left menu option
    And Super Admin on the "Jobs" and "JobCreate" module
    Then Super Admin chooses a company and clicks the "+" button to create a new job

  Scenario: Super Admin fills the required fields in Basics section, select for "Position Name","Employment Type",
  "Country","City","Contract Type","Workplace","Application Closing Date","Expected Started Date","Salary Preferences","Salary",
  "Currency","Language" , write "Job Title"
    When Super Admin should be able to see the Page Title as a "Basics"
    And User clicks and select fills related dropdown fields in Basics
      |Position Name            | QA Developer|
      |Employment Type          | Full Time   |
      |Country                  | UK          |
      |City                     | London      |
      |Contract Type            | Permanent   |
      |Workplace                | Remote      |
      |Application Closing Date | 10.02.2024  |
      |Expected Started Date    | 01.03.2024  |
      |Salary Preferences       | Per month   |
      |Salary                   | 3000-5000   |
      |Currency                 | GBP         |
      |Language                 | English     |
      |Job Title                | QA Engineer |

    And Super Admin click "Next" button
    Then The user should be able to see  "Your Basics info has been submitted successfully" message in the alert section

  Scenario: Super Admin fills the required fields in the Details section
    When Super Admin should be able to see the Page Title as a "Details"
    And Super Admin clicks "suggested skills" on the required fields
      | Net. Reflector|
    And Super Admin click "Next" button
    Then The user should be able to see  "Your job details info has been submitted successfully" message in the alert section

  Scenario: Super Admin fills in the Role Responsibility section
    When Super Admin should be able to see the Page Title as a "Role Responsibility"
    And Super Admin writes "Creation and maintenance of automated test scripts" on the required fields
    And Super Admin click "Next" button
    Then The user should be able to see  "Your Role Responsibility has been submitted successfully" message in the alert section

  Scenario: Super Admin fills in the Interview Process section
    When Super Admin should be able to see the Page Title as a "Interview Process"
    And Super Admin clicks "First Round Interview" and "Click on "Second Round Interview" check boxes from Interview Process
    And Super Admin click "Next" button
    Then The user should be able to see  "Your interview process info has been submitted successfully" message in the alert section

  Scenario: Super Admin fills in the Benefits section
    When Super Admin should be able to see the Page Title as a "Benefits"
    And Super Admin clicks on "25 days annual leave" check box from Benefits
    And Super Admin click "Next" button
    Then The user should be able to see  "Your Benefits info has been submitted successfully" message in the alert section

  Scenario Outline: Super Admin reviews Job Summary
    When Super Admin should be able to see the Page Title as a "Job Summary"
    And Super Admin clicks "<Sections>" and super admin should be able to see the section title
    Examples:
        | Sections           |
        | Basics             |
        | Details            |
        |Role Responsibility |
        |Interview Process   |
        | Benefits           |

  Scenario Outline: Given information should be saved in each section in the Job Summary
    When Super Admin clicks the "<sections>" Super admin should see the "<saved information>"
    Examples:
      | sections           | saved information                                              |
      | Basics             |QA Developer                                                    |
      | Details            |Net. Reflector                                                  |
      |Role Responsibility |Creation and maintenance of automated test scripts              |
      |Interview Process   |First Round Interview                                           |
      | Benefits           |25 days annual leave                                            |


  Scenario: information should be editable in each section in the Job Summary
    When Super Admin clicks the Basics section icon
    And Super Admin changed job title  as "SDET"
    And Super Admin clicks on save button
    Then Super Admin should be able to see "Your Basics info has been submitted successfully"
    And Super Admin clicks on Create button
    Then Super Admin should be able to see "Job has been created successfully" message

  Scenario: Super Admin views created job details
    And Super Admin should see the "VIEW JOBS" button
    And Super Admin clicks "VIEW JOBS"
    Then Super Admin should be on the "View Short List" page
    And Super Admin clicks and write on the search button Job Title and see the new job on the job list board
    Then Admin should see Job Details page