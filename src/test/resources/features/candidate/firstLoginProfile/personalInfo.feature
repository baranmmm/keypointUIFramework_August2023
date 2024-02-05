Feature: Personal Info

  Background:
    Given the "candidate" logs in successfully
    And navigates to "Personal Info" page

  Scenario: Candidate should be able to add and save Personal Info
    Then verifies * icon is visible upon First Name,Last Name,Linkedin and Email address fields
    Then verifies First Name,Last Name,Linkedin and Email address fields are automatically filled in.
    Then verifies First Name,Last Name,Linkedin and Email address fields are non-editable.
    And clicks on Country menu and selects "Country"
    Then verifies City menu activates
    And clicks on City menu and selects "City"
    And clicks on Country Code menu and selects "Code"
    And enters "7-digit mobile phone number" in Mobile field
    And clicks on "Next" button
    Then verifies "Personal information has been submitted successfully." alert is seen
    Then verifies landing on "Upload CV" page
    #Then verifies circle next to "Personal Info" on the left menu has a tick symbol
    And clicks on "Back" button
    Then verifies landing on "Personal Info" page
    And clicks on "Exit" button
    Then verifies landing on "Dashboard" page
    And the user navigates "Profile" left menu option
    #Then verifies circle next to "Personal Information" with green tick symbol is visible

  Scenario Outline: Candidate should not be able to save Personal Information with invalid Mobile Phone Number
    And clicks on Country Code menu and selects "Code"
    And enters "<Mobile Phone>" in Mobile field
    Then verifies "<Warning Message>" is seen
    Examples:
      | Mobile Phone    | Warning Message                                  |
      | 258369          | Mobile number must consist of at least 7 digits. |
      | 258369258369123 | Mobile number cannot be longer than 14 digits.   |
      | 1334Abc         | Mobile number must include only digits.          |
      | 1334/*??        | Mobile number must include only digits.          |

    
    Scenario: Candidate should be able to save Personal Information without filling optional fields Country,City and Country Code
      And clicks on Country menu and selects "None"
      Then verifies that City dropdown menu does not activate
      And clicks on Country Code menu and selects "None"
      And enters "14-digit mobile phone number" in Mobile field
      And clicks on "Next" button
      Then verifies "Personal information has been submitted successfully." alert is seen
      And clicks on "Back" button
      And clicks on Country Code menu and selects "Code"
    # And leaves Mobile Phone field blank !!Blank not accepted.Bug has to be fixed
      And clicks on "Next" button
      Then verifies "Personal information has been submitted successfully." alert is seen













