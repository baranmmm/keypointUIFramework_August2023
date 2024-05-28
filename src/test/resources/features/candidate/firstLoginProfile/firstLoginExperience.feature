@regression
Feature: Work Experience Section

  Background:
    Given the "candidate" logs in successfully
    And navigates to Profile Sections page
    And the candidate clicks on "Experience" button on the left-hand side menu

  Scenario: Candidate completes the Experience section successfully
    Then the candidate sees "Please add your work experience." request, Title, Company checkboxes, Contract Type, Workplace, Start Date, End Date dropdowns, skill sets dropdown, currently working text, Text field, and ADD MORE EXPERIENCE button
    And the candidate clicks on the Next button without completing all the required fields
   Then verifies the warning messages for Title, Company, Start Date, End Date and Skill Set
   Then verifies "Please choose at least one tool you used while working in this position." for the skillset dropdown
  #  When the candidate clicks on the currently working button
  #  Then verifies the End Date is not enabled and the Notice Period dropdown appears
  #  And verifies visibility of Notice Period options by clicking on it
  #  When the candidate clicks on the Next button without selecting an option from the Notice Period dropdown
  #  Then verifies "Please indicate the notice period." warning message is displayed
  #  When the candidate clicks on the Title and types "<TitleValue>"
  #  And the candidate clicks on the Company and types "<CompanyValue>"
 #   And the candidate clicks on the Start Date and types "<StartDateValue>"
  #  And the candidate clicks on the End Date and types "<EndDateValue>"
  #  And the candidate selects "<ContractType>" from the Contract Type dropdown
 #   And the candidate selects "<Workplace>" from the Workplace dropdown
  #  And the candidate clicks on the skill sets button and selects "<Tools>"
   # And clicks on "NEXT" button
   # Then a success message "has been submitted successfully" should be displayed
  #  Then verifies landing on "Language" page
  #  And the candidate clicks on "Experience" button on the left-hand side menu
  #  And after typing or selecting some options, verifies the visibility of the DELETE button
   # And clicks on the DELETE button to delete all entered data
   # And verifies that all data are cleared
   # And clicks on "Back" button
  #  Then verifies landing on "Industry" page
   # And the candidate clicks on "Language" button on the left-hand side menu
   # And clicks on "Exit" button
  #  Then verifies landing on "Dashboard" page

  #  Examples:
  #    | Title  | Company | StartDateValue | EndDateValue | ContractType | Workplace | Tools  |
   #   | QA     | ABC     | 10.2022        | 10.2023      | Permanent    | Hybrid    | AWS    |

