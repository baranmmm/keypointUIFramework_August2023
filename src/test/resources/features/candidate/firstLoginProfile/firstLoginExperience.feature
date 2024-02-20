@regression
Feature: Work Experience Section

  Background:
    Given the "candidate" logs in successfully
    When navigates to "Experience" page

  Scenario Outline: Candidate completes the Experience section successfully
    Then the candidate sees "Please add your work experience." request
    And the candidate clicks on the Next button without completing all the required fields
    Then verifies the warning messages for Title, Company, Start Date, End Date and Skill Set
    Then verifies "Please choose at least one tool you used while working in this position." for the skillset dropdown
    When the candidate clicks on the currently working button
    Then verifies the End Date is not enabled and the Notice Period dropdown appears
    And verifies visibility of Notice Period options by clicking on it
    When the candidate clicks on the Next button without selecting an option from the Notice Period dropdown
    Then verifies "Please indicate the notice period." warning message is displayed
    And the candidate clicks on the currently working button to activate the end date dropdown
    Then verifies activation of the end date dropdown
    When the candidate clicks on the Title and types "<TitleValue>"
    And the candidate clicks on the Company and types "<CompanyValue>"
    And the candidate clicks on the Start Date and types "<StartDateValue>"
    And the candidate clicks on the End Date and types "<EndDateValue>"
    And the candidate clicks on the skill sets button and selects Tools
    And the candidate clicks on the Add More Experience button to see the additional fields
    Then verifies the additional experience fields
    And clicks on "NEXT" button
    Then a success message "has been submitted successfully" should be displayed
    Then verifies landing on "Language" page
    And the candidate clicks on "Experience" button on the left-hand side menu
    And after typing or selecting some options, verifies the visibility of the DELETE button
    And clicks on the DELETE button to delete all entered data
    And verifies that all data are cleared
    And clicks on "Back" button
    Then verifies landing on "Industry" page
    And the candidate clicks on "Language" button on the left-hand side menu
    And clicks on "Exit" button
    Then verifies landing on "Dashboard" page

    Examples:
      | TitleValue  | CompanyValue | StartDateValue | EndDateValue |
      | QA          | ABC          | 10.2022        | 11.2023      |

  Scenario Outline: Additional fields cannot be opened unless mandatory fields are filled
    When the candidate clicks on the Add More Experience button while the mandatory fileds are not filled
    Then verifies the warning messages "<TitleMessage>", "<CompanyMesage>" , "<StartDateMessage>" , "<EndDateMessage>" , "<SkillSetMessage>"
    Examples:
      | TitleMessage         | CompanyMesage                | StartDateMessage             | EndDateMessage             | SkillSetMessage                                                          |
      |Please enter a title. | Please enter a company name. | Please enter the start date. | Please enter the end date. | Please choose at least one tool you used while working in this position. |

  Scenario Outline: Additional fields can be oppened through ADD MORE button
    When the candidate clicks on the Title to type "<Title>"
    And the candidate clicks on the Company to type "<Company>"
    And the candidate clicks on the Start Date to type "<StartDate>"
    And the candidate clicks on the End Date to type "<EndDate>"
    And the candidate clicks on the skillsets button to selects Tools
    And clicks on the add more experience button to see the additional fields
    Then verifies the additional experience fields are visible
    Examples:
      | Title | Company | StartDate | EndDate |
      | QA    | ABC     | 10.2022   | 11.2023 |

  Scenario: Candidate should be able to select one option of the workplace among "Hybrid, Remote, Onsite" options from the "Workplace"
    When The candidate clicks on the Workplace dropdown
    And The candidate selects the one option from the Workplace dropdown
    Then The candidate verifies all the Workplace dropdown options
      | Hybrid |
      | Remote |
      | Onsite |


  Scenario: The workplace dropdown should be empty when the "None" option is selected
    When The candidate selects the "None" option from the Workplace dropdown
    Then The candidate verifies that the Workplace dropdown is empty


  Scenario: Contract Type dropdown should be clickable  and its options should be visible
    When The candidate clicks on the Contract Type dropdown
    And The candidate selects one option from the Contract Type dropdown
    Then The candidate verifies all the Contract Type dropdown's options
      | Permanent               |
      | Contract                |
      | Part time               |
      | Freelance               |
      | Axios                   |
      | Any                     |
      | Temporary               |
      | Contract (Inside IR35)  |
      | Contract (Outside IR35) |


  Scenario: "1 week", "2 weeks", "3 weeks", "4 weeks", "5 weeks", "6 weeks", "2 months" and "3+ months" options should be visible and clickable in the "Notice Period" dropdown
    When The user clicks to the Notice Period dropdown menu
    And The user clicks on one option randomly from the Notice Period dropdown menu
    Then Verify that user sees all the Notice Period dropdown menu
      | 1 week    |
      | 2 week    |
      | 3 week    |
      | 4 week    |
      | 5 week    |
      | 6 week    |
      | 2 months  |
      | 3+ months |

  Scenario: Candidate types less than Max 500 characters in the textbox
    When The candidate clicks on the "Type to add more information." textbox to add more information
    And The candidate types that "I am interested in API testing." in there
    Then Verifies that "I am interested in API testing." in the textbox


  Scenario: Candidate types 500 characters into the textbox
    When The candidate clicks on the "Type to add more information." textbox to type max characters in there
    And The candidate types 500 characters in this textbox
    Then Verifies that 500 characters are in the textbox

  Scenario: Candidate types 501 characters in the textbox
    When The candidate clicks on the "Type to add more information." textbox to type more than max character in there
    And The candidate types 501 characters as more than max character
    Then Verifies that 501 characters can not be seen in the textbox
