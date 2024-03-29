@regression
@ExperienceModule
Feature:Verify visibility and click ability of "Experience" module subtitles on the "Profile" page

  Background:
    Given the user "candidate" logs in successfully
    And the user navigates "Profile" left menu option
    And The user on the "Experience" module


  @exp
  Scenario Outline: Verify Input Box Titles and Dropdowns on Experience Module
    When The user clicks to the "<Title>" and type text
    Then The user verifies that should see the "Title*" input box
    And The user clicks to the "<Company>" and type company
    Then The user verifies that should see the "Company*" input box
    And The user clicks to the "<Contract Type>" and select an option
    Then The user verifies that should see the "Contract Type" dropdown
    And The user clicks to "<Workplace>" and select an option
    Then The user verifies that should see the "Workplace" dropdown
    And The user clicks to the "<Start Date>" and type startDate
    Then The user verifies that should see the "Start Date*" input box
    And The user clicks to the "<End Date>" and type endDate
    Then The user verifies that should see the "End Date*" input box
    And The user clicks to the "<Please choose all the skill sets you used while working in this experience module.>" module and select an option
    Then The user verifies should see "Please choose all the skill sets you used while working in this experience module.*" dropdown

    Examples: Filling the experience fields with information
      | Title                | Company  | Start Date | End Date | Contract Type | Workplace | Please choose all the skill sets you used while working in this experience module. |
      | Software QA Engineer | KeyPoint | 12.2021    | 12.2022  | Permanent     | Remote    |                                                                                    |

  @exphappypath
  Scenario Outline: Verify Input Boxes and Dropdowns are mandatory on the Experience Module-Happy Path
    When The user clicks to the "<Title>" and type text
    And The user clicks to the "<Company>" and type company
    And The user clicks to the "<Start Date>" and type startDate
    And The user clicks to the "<End Date>" and type endDate
    And The user clicks to the "<Please choose all the skill sets you used while working in this experience module.>" module and select an option
    And The user clicks to the save button
    Then The user verifies the success message is displayed
    Examples: Filling the experience fields which are mandatory on the Experience module
      | Title                  | Company | Start Date | End Date | Please choose all the skill sets you used while working in this experience module. |
      | Software Test Engineer | ABC     | 12.2022    | 08.2023  |                                                                                    |

  @expnegative
  Scenario Outline:Verify Input Boxes and Dropdowns are mandatory fields to fill on the Experience Module and Warning Messages-Negative
    When The user clicks to the "<Title>" and type text
    And The user clicks to the "<Company>" and type company
    And The user clicks to the "<Start Date>" and type startDate
    And The user clicks to the "<End Date>" and type endDate
    And The user clicks to the "<Please choose all the skill sets you used while working in this experience module.>" module and select an option
    And The user clicks to the save button
    Then The user verifies the "<warning message>" is displayed

    Examples: Filling the experience fields which are mandatory on the Experience module

      | Title                  | Company  | Start Date | End Date | Please choose all the skill sets you used while working in this experience module. | warning message                              |
      |                        | ABC      | 12.2022    | 08.2023  |                                                                                    | Please enter a title.                        |
      | Software Test Engineer |          | 12.2022    | 08.2023  |                                                                                    | Please enter a company name.                 |
      | Software Test Engineer | ABC      | 12.2022    |          |                                                                                    | Please enter the end date.                   |
      | Software Test Engineer | ABC      | 122022     | 08.2023  |                                                                                    | Please enter a valid date (e.g. 01.1990)     |
      | QA Tester              | ABC      | 05.2000    | 05.1998  |                                                                                    | The end date must come after the start date. |
#       Start date girilmeden End date' e data girisi yapilamadigindan startdate in altindaki uyari mesajini verify edemiyorum.
#      | Backend Developer      | KeyPoint |            |          |                                                                                    | Please enter the start date.                 |
      | Backend Developer      | KeyPoint | 10.2001    | 10/2002  |                                                                                    | Please enter a valid date (e.g. 01.1990)     |
      | Backend Developer      | KeyPoint | 10.2001    | 13.2002  |                                                                                    | Please enter a valid date (e.g. 01.1990)     |
      | Software Tester        | Yahoo    | 01.1980    | 11.2023  |                                                                                    |                                              |
# Uyari mesaji yerine "Request failed with status code 406" popup mesaji aldigimdan sinir degerleri alltaki gibi ayri senaryolarla test ettim,dolayisiyla warning messajlar test edilemiyor.
#      | Software Test Engineer | ABC      | 12.1979    | currentDate |                                                                                    |"startYear cannot before 01.01.1980"|
#      | Software Test Engineer | ABC      | 01.1980    | currentDate+1Month  |                                                                                    |"endYear  cannot after now"|

  @NegativeStartYear
  Scenario: Verify Input Boxes and Dropdowns are mandatory fields to fill on the Experience Module and Warning Messages-Negative2
    When The user clicks to the Title, Company, negativeStartDate, and EndDate input boxes and inputs necessary informations
    And The user clicks to the "<Please choose all the skill sets you used while working in this experience module.>" module and select an option
    And The user clicks to the save button
    Then The user verifies the "Request failed with status code 406" popup message is displayed on the experience page

  @NegativeEndYear
  Scenario: Verify Input Boxes and Dropdowns are mandatory fields to fill on the Experience Module and Warning Messages-Negative3
    When The user clicks to the Title, Company, StartDate, and negativeEndDate input boxes and inputs necessary informations
    And The user clicks to the "Please choose all the skill sets you used while working in this experience module." module and select an option
    And The user clicks to the save button
    Then The user verifies the "Request failed with status code 406" popup message is displayed on the experience page

  @skillSetOptionsRemove
  Scenario: Verify that SkillSet Options are removed and getting warning message
    When The user clicks to the Title,Company,StartDate,and EndDate input boxes and types "Software Test Engineer","Keypoint","12.2000",and "12.2005"
    And The user clicks to the "<Please choose all the skill sets you used while working in this experience module.>" module and select an option
    And The user clicks to the selected options to remove the skills from the skillset dropdown
    And The user clicks to the save button
    Then The user verifies the "Please choose at least one tool you used while working in this position." is displayed

  @skillSetNegative
  Scenario: Verify that SkillSet Options are mandatory field to fill and getting warning message
    When The user clicks to the Title,Company,StartDate,and EndDate input boxes and types "Software Test Engineer","Keypoint","12.2000",and "12.2005"
    And The user clicks to the Skill Set dropdown in the experience module and not select any options
    And The user clicks to the save button
    Then The user verifies the "Please choose at least one tool you used while working in this position." is displayed

  @checkbox1
  Scenario: Verify that the Notice Period dropdown is visible and mandatory when the checkbox is selected
    When The user clicks "I am currently working in this position." checkbox
    And The user verifies that should see the "I am currently working in this position." checkbox.
    And  The user should see "Notice Period*" dropdown  menu
    And The user should click "Notice Period*" dropdown  menu
    And the "1 week" field should be mandatory to select

  @checkbox2
  Scenario: Verify User should not see or select the "End Date" input box when "I am currently working in this position" checkbox is checked
    When  The user clicks the "I am currently working in this position" checkbox
    Then The user should not see the "End Date" input box
    And The user should not be able to select the "End Date" input box

  @buttons
  Scenario: ADD MORE EXPERIENCE, CANCEL and SAVE buttons should be visible and clickable
    Then  the ADD MORE EXPERIENCE, CANCEL and SAVE buttons should be visible
    And the ADD MORE EXPERIENCE, CANCEL and SAVE buttons should be clickable

  @moreExpBtn
  Scenario: Verify the user clicks the ADD MORE EXPERIENCE button, the user should add more experiences
    When The user clicks the ADD MORE EXPERIENCE button
    Then Verify that user should add more experiences

  @deletePositive
  Scenario: The "Delete" button should be visible and clickable only if the user selects items from the dropdowns and types the text into the input boxes
    When   The user clicks to the Title,Company,StartDate,and EndDate input boxes and types "Software Test Engineer","ABC","12.2000",and "13.2005"
    And    The user clicks to the "<Please choose all the skill sets you used while working in this experience module.>" module and select an option
    Then   Verify that Delete button should be visible
    Then   Verify that Delete button should be clickable


  @deleteNegative
  Scenario: The "Delete" button should not be visible if the user not selects items from the dropdowns and types the text into the input boxes

    When The user has not selected any items from the dropdowns or typed any text into the input boxes
    Then Verify that "Delete" button should not be visible

  @deleteBtn
  Scenario: Users should be able to delete added experience fields using the "delete" button at the top right of the Experience module
    When   The user clicks to the Title,Company,StartDate,and EndDate input boxes and types "Software Test Engineer","ABC","12.2000",and "13.2005"
    And    The user clicks to the "<Please choose all the skill sets you used while working in this experience module.>" module and select an option
    And   The user clicks the "Delete" button at the top right of the Experience module
    Then  Verify that the experience fields should be deleted

  @workplacePositive
  Scenario: Users should be able to select one option of the workplace among "Hybrid, Remote, Onsite" options from the "Workplace" dropdown and verify them
    When The user clicks to the Workplace dropdown menu
    And The user selects the one option randomly from the Workplace dropdown
    Then Verify that user sees all the Workplace dropdown options
      | Hybrid |
      | Remote |
      | Onsite |


  @workplaceNegative
  Scenario: If the user selects the "none" option, the Workplace dropdown should be empty
    When The user selects the "none" option from the Workplace dropdown
    Then Verify that the Workplace dropdown should be empty

  @ContractTypes
  Scenario: "Permanent, "Contract", "Part time", "Freelance", "Axios", "Any", "Temporary", "Contract (Inside IR35)" and "Contract (Outside IR35)" options should be visible and clickable in the "Contract Type" dropdown menu
    When The user clicks to the Contract Type dropdown menu
    And The user clicks on one option randomly from the Contract Type dropdown menu
    Then Verify that user sees all the Contract Type dropdown menu
      | Permanent               |
      | Contract                |
      | Part time               |
      | Freelance               |
      | Axios                   |
      | Any                     |
      | Temporary               |
      | Contract (Inside IR35)  |
      | Contract (Outside IR35) |

  @noticePeriod
  Scenario: "1 week", "2 weeks", "3 weeks", "4 weeks", "5 weeks", "6 weeks", "2 months" and "3+ months" options should be visible and clickable in the "Notice Period" dropdown
    When The user clicks to the Notice Period dropdown menu
    And The user clicks on one option randomly from the Notice Period dropdown menu
    Then Verify that user sees all the Notice Period dropdown menu
      | 1 week    |
      | 2 weeks   |
      | 3 weeks   |
      | 4 weeks   |
      | 5 weeks   |
      | 6 weeks   |
      | 2 months  |
      | 3+ months |

  @infoTextBox
  Scenario: The user clicks "Type to add more information." textbox, user should be able to see, type and enter Max 500 Characters in the textbox
    When The user clicks the "Type to add more information." textbox
    And The user types "This is a test string." in the Type to add more information textbox
    Then Verify that user should see the "This is a test string." text in the Type to add more information textbox

  @infoMaxCharPositive
  Scenario:The user verify that should enter Max 500 characters to the textbox

    When The user clicks the "Type to add more information." textbox
    And The user enters 500 characters in the text box
    Then Verify that user sees to type Max 500 characters

  @infoMaxCharNegative
  Scenario: The user verify that should not enter Max 501 characters to the textbox

    When The user clicks the "Type to add more information." textbox
    And The userS enters 501 characters in the text box
    Then Verify that user sees not to type 501 characters








