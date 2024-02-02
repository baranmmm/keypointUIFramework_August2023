
  Feature: Personal Info
    Background:
      Given the "candidate" logs in successfully
      And navigates to Profile Sections page

    Scenario: User should be able to add and save Personal Info
      Then verifies * icon is visible upon First Name,Last Name,Linkedin and Email address fields
      Then verifies First Name,Last Name,Linkedin and Email address fields are automatically filled in.
      Then verifies First Name,Last Name,Linkedin and Email address fields are non-editable.
      When selects None as country
      Then verifies that City dropdown menu does not activate
      And selects a Country
      Then verifies City dropdown menu activates
      And enters a "valid mobile" number
      And clicks on "Next" button
      Then verifies "Personal Information has been submitted successfully" alert is seen
      Then verifies circle next to "Personal Info" has a tick symbol
      Then verifies landing on "Upload CV" page
      And clicks on "Back" button
      Then verifies landing on "Personal Info" page
      And clicks on "Exit" button
      Then verifies landing on "Dashboard" page
      And the user navigates "Profile" left menu option
      Then verifies circle next to "Personal Information" with green tick symbol is visible
      And the user clicks on "Language" button on the left hand side menu
      Then verifies "Please choose at least" alert is seen







