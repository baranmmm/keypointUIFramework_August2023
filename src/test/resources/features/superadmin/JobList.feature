@regression
Feature: Admin should be able to see and update the jobs list under Activity Section

  Background:
     Given User "superadminEmail" logs in successfully
#     When User navigates to jobList
    * the user navigates "Activity" left menu option
    * the user navigates "Jobs" left menu option
    *  the user navigates "Jobs List" left menu option



    Scenario:TC_01 Verify the url contains jobList
      Then Verify the page url contains "jobs-list"

    Scenario:TC_02 Verify the job list column names
      Then Column names should be displayed

  @jobList
    Scenario: TC_03 Pagination verification
       And Clicks on the "Next Page" arrow button
      Then Verify the text contains "6-10 of"
      When Clicks on the "Previous Page" arrow button
      Then Verify the text contains "1-5 of"

    Scenario: TC_06 Verify the default page size
      Then Default page size should be 5

    Scenario: TC_07 Verify the firs_Page and last_page work correctly
      And clicks on the lastPage
      Then Verify the lastpage text contains "last_page"
      When clicks on the firstPage
      Then Verify the firstPage text contains "first_page"




