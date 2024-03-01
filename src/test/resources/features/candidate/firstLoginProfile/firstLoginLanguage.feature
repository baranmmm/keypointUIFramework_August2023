Feature: Language Proficiency Section Completion

  Background:
    Given the "candidate" logs in successfully
    When navigates to "Language" page

  @PositiveLanguage
  Scenario: Candidate successfully completes the Language section with multiple languages and proficiencies
    Then the candidate should see "Please add all the languages you know." under the Language header
    And the candidate removes the selected options to type German in the searchbar
    When the candidate searches for "German" in the language search bar
    And the candidate selects German from the search results
    And the candidate selects an option from the dropdown
    And the candidate clicks on the selected language German
    Then the candidate verifies that "German" and its proficiency dropdown are no longer visible
    And the candidate clicks on three language options step by step
    Then verifies visibility of the selected options
    And the candidate removes all the language options by clicking on them
    And the candidate types "English" in the language search bar
    And the candidate selects the language from the search results
    And clicks on the Next button to complete the action
    Then a success message "Your language data has been submitted successfully." should be displayed
    Then verifies landing on "Experience" page
    And the candidate clicks on "Language" button on the left-hand side menu
    And clicks on "Back" button
    Then verifies landing on "Industry" page
    And the candidate clicks on "Language" button on the left-hand side menu
    And clicks on Exit button
    Then verifies landing on "Dashboard" page

  @NegativeLanguage1
 Scenario: Candidate attempts to proceed without selecting a language
    When the candidate clicks on the selected language option
    And clicks on "NEXT" button
    Then verifies "Please choose at least" alert is seen


  @NegativeLanguage2
  Scenario: Candidate attempts to type a language not suggested in the search bar
    When the candidate types "Spanish" in the search bar
    Then verifies that the suggested Languages under the search bar disappear
    And clicks on "NEXT" button
    Then verifies "Please choose at least" alert is seen


