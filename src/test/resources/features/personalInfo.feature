@regression
@personal
Feature:As a user, I should be able to update "Country", "City",
  "Country Code" and "Mobile" information in  the "Personal Information" page

  Background:
    Given the "candidate" logs in successfully
    And the user navigates "Profile" left menu option

  @personalAvailability
  Scenario: User opens "Personal Information" menu successfully
    When User on the "Profile" page,sees "Personal Information" menu available
    And  User click on the pen icon,the menu expends
    And  User clicks on arrow,the menu collapse
    Then User clicks on "Personal Information" menu expands again

  @personalMenuPageElements
  Scenario: .When user opens "Personal Information" page "First Name", "Last Name", "LinkedIn",
  "Country", "City", "E-mail" , "Country Code" and "Mobile" input boxes(titles) should be seen.
    When User on the "Personal Information" page,sees "Personal Information" menu available
    And User click on the pen icon,the menu expends
    Then User sees "First Name*", "Last Name*", "LinkedIn*","E-mail*","Mobile"  elements
    Then User sees "Country","City"and "Country Code" elements dropdowns

  @personalGivenFields
  Scenario: When user opens "Personal Information" page "First Name", "Last Name", "LinkedIn" and "E-mail"
  input boxes(titles) should be given in input box and these input boxes don't accept another input.
    When User clicks on "Personal Information" menu expands again
    And User sees firstName,lastName,LinkedIn and E_mail information already given
      | firstName | Maizie                            |
      | lastName  | Garza                             |
      | LinkedIn  | https://www.linkedin.com/in/Garza |
      | E_mail    | Garza@yopmail.com                 |
    Then User cannot change registered information

    @CountryDropdown
    Scenario: User sees that  user clicks the on "Country" input box ,dropdown menu should be opened and includes
    "None", "Wales","Northern Ireland", "Scotland", "England", "UK" options.
      When User clicks on "Personal Information" menu expands again
      When User clicks "Country" input box
      And "Country" dropdown menu should be opened and includes "None", "England","Wales","Northern Ireland", "Scotland", "UK" options.
      And User selects "None" option,"City"input box is not clickable
      And User  leaves "Country" input box  empty "City" input box is not clickable
      And User clicks the England option "None" and 55 cities should be available to select in "City"dropdown.
      And User clicks the Wales option "None" and 6 cities should be available to select in "City"dropdown.
      And User clicks the Northern Ireland option "None" and 6 cities should be available to select in "City"dropdown.
      And User clicks the Scotland option "None" and 8 cities should be available to select in "City"dropdown.
#     And User  clicks the UK option "None" and 75 cities should be available to select in "City"dropdown.(This is a suggestion but not included in swagger)
      And User  clicks the UK option "None" and 1 cities should be available to select in "City"dropdown.

#this file is still under progress








