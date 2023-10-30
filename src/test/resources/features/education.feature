Feature: Education

  Background:
    Given the "candidate" logs in successfully
    And the user navigates "Profile" left menu option
    And Verify that "Education" module is visible.


  Scenario: User should see all of the modules as collapsed. Education module should be visible among other Profile modules and when it's clicked, it should be expanded.
    Then Test that education module is expanded after it's clicked on the pencil icon.

  Scenario: Verifiying "University", "Degree", "Department", "Start Year" drop-down mandatory fields and "End Year" drop-down fields are visible, all fields are relivable selecting only single option.
    Then user verifies University,Degree,Department ,Start Year ,End Year fields are visable

@educationSc3
  Scenario Outline: Test that "University", "Degree", "Department", "Start Year" fields are mandatory
    And  user clicks the  delete icon if delete icon is seen
    When user enters "<University>", "<Degree>", "<Department>", "<Start Year>" fields
    Then user sees "<Message>" under related fields
    Examples:
      | University       | Degree | Department  | Start Year | Message                        |
      |                  | Master | Advertising | 2019       | Please enter your university.  |
      | Aston University |        | Advertising | 2019       | Please choose your degree.     |
      | Aston University | Master |             | 2019       | Please choose your department. |
      | Aston University | Master | Advertising |            | Please choose the start year.  |

  @wip1
  Scenario: User should be able to delete the education using the 'delete'/delete icon which is at the top right of education form
    And user clicks the  delete icon if delete icon is seen
    And user clicks + ADD EDUCATION button
    Then user verifies following messages
      | Please enter your university.  |
      | Please choose your degree.     |
      | Please choose your department. |
      | Please choose the start year.  |

  Scenario Outline: User should be able to add more education using the  + ADD EDUCATION button.
    When  user clicks the  delete icon if delete icon is seen
    Then Test that + ADD EDUCATION button is clickable.
    And user enters "<University>", "<Degree>", "<Department>", "<Start Year>","<End Year>" fields
    When user clicks SAVE button
    Then Test that user should see screen with "Your education info has been added successfully." alert message
    Examples:
      | University       | Degree | Department  | Start Year | End Year |
      | Aston University | Master | Advertising | 2019       | 2023     |

  Scenario: When user types a new field in the search box and clicks "ADD" button, the new filed should be added succesfully as greened. When user cliks any sugested field, it should be seen below as greended.
    When  user should be able to write certificate type to add search box
    Then Then test that ADD button is clickable
    And user click ADD button
    Then Test that a filed should be added which is not in suggested fields and should be seen succesfully message "Your Certificate has been saved successfully."

  Scenario: Verify the 'ADD' button is clickable.Typing any letters in searchbox, should be verified that all seen result contain the letters
    When  user should be able to write any letters type to add search box
    Then Test that all related certificates are seen


  Scenario: Test that when a field suggested is clicked , it is seen as greened in below.After clicking x button,selected certificates are deleted
    When user should click one of the suggested certificates
    Then Test that it is seen as greened in below
    And  user should delete selected fields using the x button
    Then Test that selected certificates are deleted clicking the button.


  Scenario: Under the "Suggested certificates" options, the "See More" button should be visible and clickable
    Then  Test that See More button should be seen under the Suggested certificates options.
    When User should click SEE MORE button
    Then Test that user should see the See Less button end of the Suggested certificates options


  Scenario Outline:User should be able to click "SAVE" button and user should see the fields that choosen on the screen with "Your education data has been submitted successfully.
    And user enters "<University>", "<Degree>", "<Department>", "<Start Year>","<End Year>" fields
    When user should click one of the suggested certificates
    Then Test that SAVE button is clickable
    When user clicks SAVE button
    Then Test that user should see screen with "Your education data has been submitted successfully." message alert on the page .
    Then Test that user sould be able to see saved education info on the screen

    Examples:
      | University       | Degree | Department  | Start Year | End Year |
      | Aston University | Master | Advertising | 2019       | 2023     |

  Scenario Outline: User should be able to click "CANCEL" button and cancel the last changes before the saving.
    And user enters "<University>", "<Degree>", "<Department>", "<Start Year>","<End Year>" fields
    When user should click one of the suggested certificates
    When user clicks SAVE button
    And user enters "<University>", "<Degree>", "<Department>", "<Start Year>","<End Year>" fields
    And user click CANCEL button
    Then Test that CANCEL button is clickable
    Then Test that user cancel the last changes before the saving
    Examples:
      | University       | Degree | Department  | Start Year | End Year |
      | Aston University | Master | Advertising | 2019       | 2023     |