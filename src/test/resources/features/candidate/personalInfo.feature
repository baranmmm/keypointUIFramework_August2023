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
#    When User on the "Personal Information" page,sees "Personal Information" menu available
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
    And User selects None option,City input box is not clickable
    And User  leaves Country input box  empty City input box is not clickable
    And User clicks the England option "None" and 55 cities should be available to select in City dropdown.
    And User clicks the Wales option "None" and 6 cities should be available to select in City dropdown.
    And User clicks the Northern Ireland option "None" and 6 cities should be available to select in City dropdown.
    And User clicks the Scotland option "None" and 8 cities should be available to select in City dropdown.
#     And User  clicks the UK option "None" and 75 cities should be available to select in City dropdown.(This is a suggestion but not included in swagger)
    And User  clicks the UK option "None" and 1 city should be available to select in City dropdown.

  @countryCode
  Scenario:User clicks on "Country Code" input box, "None" and "+44" options should be available to select in "Country Code" dropdown menu
#If the user selects the "None" option or leaves it empty, mobile  should start with 0 ,
#if the country code selected with a valid country code,the mobile input should not accept a number starting with 0.
#  created issue on jira for suggestions with this criteria
    When User clicks on "Personal Information" menu expands again
    When user clicks on Country Code input box
    And user sees "None" and "+44" options

  @mobile1
  Scenario Outline:As a user,should not be able to enter less than 7 digits and more than 14 digits or anything
  but numbers in mobile input box.Otherwise warning message seen below it.
    When User clicks on "Personal Information" menu expands again
    When User enter "<invalid Credentials>"digits less than seven and more than fourteen or Mobile number must include only digits.non-numeric  sees "<warning message>"

    Examples:
      | invalid Credentials | warning message                                  |
      | 12                  | Mobile number must consist of at least 7 digits. |
      | 123                 | Mobile number must consist of at least 7 digits. |
      | 1234                | Mobile number must consist of at least 7 digits. |
      | 12345               | Mobile number must consist of at least 7 digits. |
      | 123456              | Mobile number must consist of at least 7 digits. |
      | 123456789012345     | Mobile number cannot be longer than 14 digits.   |
      | 12345678901234567   | Mobile number cannot be longer than 14 digits.   |
      | 1a3b5d789012345     | Mobile number must include only digits.          |
      | aa                  | Mobile number must include only digits.          |
      | !!bbccde            | Mobile number must include only digits.          |
      | **                  | Mobile number must include only digits.          |
      | ??                  | Mobile number must include only digits.          |

  @mobile2andSave
  Scenario Outline:Entering valid credentials in mobile input box and save,see success message
    When User clicks on "Personal Information" menu expands again
    And User enter "<valid credentials>"digits between seven and fourteen in mobile input box and click save button
    And User sees "<success message>"
    Then User sees new saved information on the overview page
    Examples:
      | valid credentials | success message                                       |
      | 1234567           | Personal information has been submitted successfully. |
      | 12345678901234    | Personal information has been submitted successfully. |
      | 12345678          | Personal information has been submitted successfully. |


  @saveButton
  Scenario: User be able to update some of personal information and validate comparing with overview page
    When User clicks on "Personal Information" menu expands again
    And User sees saved information on the personal information page and validates
    And User is back to the personal information page
    And User change country,city,country code and mobile information
    And User click on save button and get success message "Personal information has been submitted successfully."
    And User on the personal information page
    Then User sees saved information on the personal information page and validates


  @cancelButton
  Scenario:
    When User clicks on "Personal Information" menu expands again
    And User sees saved information on the personal information page and validates
    And User is back to the personal information page
    And User change country,city,country code and mobile information
    And User click on cancel button
    And User sees and validate that country,city,country code and mobile information changes turns to last saved version







