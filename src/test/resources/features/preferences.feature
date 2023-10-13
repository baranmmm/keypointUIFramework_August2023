Feature: Preferences

  Background:
    Given the user provides valid credentials
    When the user clicks on login button
    And the user on the homepage and user clicks to Profile button
    And Test that "Preferences" module is visible.

  @preferencesTc01
  Scenario:Test that should see country, city, workplace, contract type, salary preference, minimum expected currency and what is your vise status
    Then User should be see following fields

  @preferencesTc02
  Scenario: User should be able to fill in the drop-down fields for country, city, workplace, contract type, salary preference, minimum expected, currency and what is your vise status
    When User clicks and select fills related dropdown fields
      | Country                   | England                 |
      | City                      | Bath                    |
      | Workplace                 | Remote                  |
      | Contract Type             | Any                     |
      | Salary Preference         | Contract                |
      | Minimum Expected Salary   | 2400                    |
      | Currency                  | USD                     |
      | What is your visa status? | I have full work permit |
    And User clicks save button
    Then The user should be able to see  "Your preferences has been submitted successfully" message in the alert section
  @preferencesTc03
  Scenario: Test that user should be able to select the workplace more than one
    When User clicks workplace box and select  three options step by step
    Then User should be able to see  selected three workplace options on the box
  @preferencesTc04
  Scenario Outline:Test that should enter 0 0r minus value and sees that it is not allowed
    When User clicks minimum expected salary box and send "<related>" values
    Then User should see warning "<message>" under the box
    Examples:
      | related | message                                     |
            #  |   0     | Please enter a valid amount (bigger than 0) |
      | -123    | Please enter a valid amount (bigger than 0) |
      |   -     | Please enter a valid amount (Only digits)   |

  @preferencesTc05
  Scenario:User should be able to click the add button and see that country city and work place are opened in the newly opened prefences section, they should be able to fill these sections and see that the information is deleted by pressing the delete button
    When User clicks and select fills related dropdown fields
      | Country                   | Northern Ireland        |
      | City                      | Bangor                  |
      | Workplace                 | Remote                  |
    When User should  click the add button
    Then User should see the country city and work place areas that open after clicking the button
    And User should click delete
    Then User should see that the country city and work place fields are deleted after clicking delete
