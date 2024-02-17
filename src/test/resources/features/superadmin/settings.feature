@settings
Feature: Super admin should be able to see, sort, filter, update and delete look-ups under Settings

  Background:
    Given the "superadmin" logs in successfully
    And the user navigates "Settings" left menu option


  Scenario: TC_01 Super admin accesses the page of managing look-ups by following Admin Dashboard > Settings
    Then verifies that it is on the settings page
    And verifies that "Browse LookUp list" table title is displayed


  Scenario: TC_02 Settings page should be designed based on Figma requirements
    Then verifies that the page is designed on Figma requirements


  Scenario: TC_03 Super admin should access the page of creating a new look-up by clicking on the "ADD LOOK UP" button
    Then verifies that ADD LOOK UP button is visible and clickable
    When clicks on ADD LOOK UP button
    Then verifies that "Look - Up Files" page head is displayed


  Scenario: TC_04 Super admin should return the page of look-up table by clicking on the "BACK" button from look-up creation page
    And clicks on ADD LOOK UP button
    Then verifies that BACK button is visible and clickable
    When clicks on BACK button
    Then verifies that "Browse LookUp list" table title is displayed


  Scenario: TC_05 Super admin should be able to see total number of look-ups in the list
    Then verifies that total number of look ups is visible


  Scenario: TC_06 Super admin should be able to see increase of total number of look-ups in the list after creating one
    And notes the total number of look ups
    And clicks on ADD LOOK UP button
    And enters "123" to parent id
    And selects "Work Place" type from the list
    And enters "testAdmin" to name
    When clicks on SAVE LOOK UP FILES button
    And the user navigates "Settings" left menu option
    And notes the total number of look ups
    Then verifies that the second record of total look ups is equal to one more than the first record


  Scenario: TC_07 Super admin should be able to see decrease of total number of look-ups in the list after deleting one
    And notes the total number of look ups
    And notes the id of the look up which is top of the list
    When clicks on delete button for look up which is on the 1 row of the list
    And notes the total number of look ups
    Then verifies that the second record of total look ups is equal to one less than the first record
    And verifies that the id of the look up top of the list is different from the noted before


  Scenario: TC_08 Super admin should be able to create a new look-up by filling up required fields which are name and type
    And notes the id of the look up which is top of the list
    And clicks on ADD LOOK UP button
    And selects "Seniority Level" type from the list
    And enters "testAdmin" to name
    When clicks on SAVE LOOK UP FILES button
    And the user navigates "Settings" left menu option
    Then verifies that the id of the look up top of the list is different from the noted before


  Scenario: TC_09 Super admin should be able to create a new look-up by filling up all fields properly
    And notes the id of the look up which is top of the list
    And clicks on ADD LOOK UP button
    And enters "123" to parent id
    And selects "Seniority Level" type from the list
    And enters "testAdmin" to name
    When clicks on SAVE LOOK UP FILES button
    And the user navigates "Settings" left menu option
    Then verifies that the id of the look up top of the list is different from the noted before


  Scenario: TC_10 Super admin should not be able to create a new look-up without filling up type field.
    And notes the id of the look up which is top of the list
    And clicks on ADD LOOK UP button
    And enters "123" to parent id
    And enters "testAdmin" to name
    When clicks on SAVE LOOK UP FILES button
    And the user navigates "Settings" left menu option
    Then verifies that the id of the look up top of the list is same as the noted before


  Scenario: TC_11 Super admin should not be able to create a new look-up without filling up name field.
    And notes the id of the look up which is top of the list
    And clicks on ADD LOOK UP button
    And enters "123" to parent id
    And selects "Seniority Level" type from the list
    When clicks on SAVE LOOK UP FILES button
    And the user navigates "Settings" left menu option
    Then verifies that the id of the look up top of the list is same as the noted before


  Scenario: TC_12 Super admin should see the prompt message "Please choose a type" when click on "SAVE LOOK UP FILES" button without filling out type
    And clicks on ADD LOOK UP button
    And enters "123" to parent id
    And enters "testAdmin" to name
    When clicks on SAVE LOOK UP FILES button
    Then verifies that "Please choose a type" prompt message is displayed under type field


  Scenario: TC_13 Super admin should see the prompt message "Please enter a name" when click on "SAVE LOOK UP FILES" button without filling out name
    And clicks on ADD LOOK UP button
    And enters "123" to parent id
    And selects "Seniority Level" type from the list
    When clicks on SAVE LOOK UP FILES button
    Then verifies that "Please enter a name" prompt message is displayed under name field


  Scenario: TC_14 Super admin should see the alert message "Request failed with status code 404" when click on "SAVE LOOK UP FILES" button without filling out parent id with an existing look-up id
    And clicks on ADD LOOK UP button
    And enters "100000" to parent id
    And selects "Seniority Level" type from the list
    And enters "TestAdmin" to name
    When clicks on SAVE LOOK UP FILES button
    Then verifies that the alert message is "Request failed with status code 404"


  Scenario: TC_15 Super admin should see the prompt message "Please enter valid parent id" when click on "SAVE LOOK UP FILES" button without filling out parent id with positive integer
    And clicks on ADD LOOK UP button
    And enters "String" to parent id
    And selects "Seniority Level" type from the list
    And enters "TestAdmin" to name
    When clicks on SAVE LOOK UP FILES button
    Then verifies that "Please enter a valid parent id" prompt message is displayed under parent id field


  Scenario: TC_16 Super admin should see the success message alert "Saved look up successfully" when click on "SAVE LOOK UP FILES" button
    And clicks on ADD LOOK UP button
    And enters "123" to parent id
    And selects "Notice Period" type from the list
    And enters "testAdmin" to name
    When clicks on SAVE LOOK UP FILES button
    Then verifies that the alert message is "Saved look up successfully"


  Scenario: TC_17 Super admin should see the success message alert "Look-up deleted successfully" when click on delete(bin) button or deletable look-up
    When clicks on delete button for look up which is on the 1 row of the list
    Then verifies that the alert message is "Look up deleted successfully"


  Scenario: TC_18 Super admin should see the fail message alert "This look up can not be deleted" when click on delete(bin) button for nondeletable look-up
    And selects "20" from the list size options
    And user clicks on the "Last Page" arrow button
    When clicks on delete button for look up which is on the 1 row of the list
    Then verifies that the alert message is "This look up can not be deleted"


  Scenario: TC_19 Super admin should be able to search look-ups by name
    And notes the total number of look ups
    And selects "20" from the list size options
    When enters "Java" to search field and press enter
    Then verifies that number of filtered look ups is less than noted total number of look ups
    And verifies that names of filtered look ups contain "Java" without case sensitivity


  Scenario: TC_20 Super admin should have to click the edit (pencil) button for editing and the cancel (X) button to cancel the edit
    Then verifies that edit (pencil) buttons are visible and clickable
    When clicks on edit button for row 4 and notes the id of that look up
    Then verifies that row 4 is on update mode
    When clicks on cancel button
    Then verifies that row 4 is not on update mode


  Scenario: TC_21 Super admin should be able to edit name of an existing look-up
    And clicks on edit button for row 4 and notes the id of that look up
    When enters "EditTest" to name field for edit
    And clicks on save button
    Then verifies that the alert message is "Look up edited successfully"
    Then verifies that the "name" of look up has id noted before is changed as "EditTest"


  Scenario: TC_22 Super admin should be able to edit type of an existing look-up
    And clicks on edit button for row 3 and notes the id of that look up
    When selects "Interview Process" type from the list for edit
    And clicks on save button
    Then verifies that the alert message is "Look up edited successfully"
    Then verifies that the "type" of look up has id noted before is changed as "Interview Process"


  Scenario: TC_23 Super admin should be able to edit parent id of an existing look-up
    And clicks on edit button for row 1 and notes the id of that look up
    When enters "123" to parent id field for edit
    And clicks on save button
    Then verifies that the alert message is "Look up edited successfully"
    Then verifies that the "parent id" of look up has id noted before is changed as "123"


  Scenario: TC_24 Super admin should not be able to change with a value that is not a positive integer when editing parent id of an existing look-up
    And clicks on edit button for row 1 and notes the id of that look up
    And notes the "parent id" of edited look up
    When enters "2.5" to parent id field for edit
    And clicks on save button
    Then verifies that the alert message is "There was an error editing this look up.Please check the data and try again."
    Then verifies that the "parent id" of look up has id noted before is not changed


  Scenario: TC_25 Super admin should not be able to change with a non-existing id when editing the parent id of an existing look-up
    And clicks on edit button for row 1 and notes the id of that look up
    And notes the "parent id" of edited look up
    When enters "100000" to parent id field for edit
    And clicks on save button
    Then verifies that the alert message is "There was an error editing this look up.Please check the data and try again."
    Then verifies that the "parent id" of look up has id noted before is not changed


  Scenario: TC_26 Super admin should not be able to change with empty string when editing the name of an existing look-up
    And clicks on edit button for row 4 and notes the id of that look up
    And notes the "name" of edited look up
    When enters "" to name field for edit
    And clicks on save button
    Then verifies that the alert message is "There was an error editing this look up.Please check the data and try again."
    Then verifies that the "name" of look up has id noted before is not changed


  Scenario: TC_27 Super admin should be able to list look-ups by 20
    When selects "20" from the list size options
    Then verifies that number of row which includes look up id is 20


  Scenario: TC_28 Super admin should be able to list look-ups by 10
    When selects "10" from the list size options
    Then verifies that number of row which includes look up id is 10


  Scenario: TC_29 Super admin should be able to list look-ups by 5
    And selects "20" from the list size options
    When selects "5" from the list size options
    Then verifies that number of row which includes look up id is 5


  Scenario Outline: TC_30 Super admin should be able to navigate end of the list
    And selects "<rowSize>" from the list size options
    And notes the total number of look ups
    And notes the row size selection
    When user clicks on the "Last Page" arrow button
    Then verifies that the last page is being viewed by using table information
    And verifies that "Last Page" button is not active anymore
    And verifies that "Next Page" button is not active anymore
    Examples:
    |rowSize|
    |5      |
    |10     |
    |20     |


  Scenario Outline: TC_31 Super admin should be able to navigate beginning of the list
    And selects "<rowSize>" from the list size options
    And notes the total number of look ups
    And notes the row size selection
    And user clicks on the "Last Page" arrow button
    When user clicks on the "First Page" arrow button
    Then verifies that the first page is being viewed by using table information
    And verifies that "First Page" button is not active anymore
    And verifies that "Previous Page" button is not active anymore
    Examples:
    |rowSize|
    |5      |
    |10     |
    |20     |


  Scenario Outline: TC_32 Super admin should be able to navigate forth through the pages of the list
    And selects "<rowSize>" from the list size options
    And notes the total number of look ups
    And notes the row size selection
    When user clicks on the "Next Page" arrow button
    Then verifies that the previous page is being viewed by using table information
    And verifies that "First Page" button is active
    And verifies that "Previous Page" button is active
    Examples:
    |rowSize|
    |5      |
    |10     |
    |20     |


  Scenario Outline: TC_33 Super admin should be able to navigate back through the pages of the list
    And selects "<rowSize>" from the list size options
    And notes the total number of look ups
    And notes the row size selection
    And user clicks on the "Last Page" arrow button
    When user clicks on the "Previous Page" arrow button
    Then verifies that the previous page is being viewed by using table information
    And verifies that "Last Page" button is active
    And verifies that "Next Page" button is active
    Examples:
    |rowSize|
    |5      |
    |10     |
    |20     |


  Scenario: TC_34 Super admin should be able to sort look-ups ascending order by id
    And selects "20" from the list size options
    When clicks on arrow button next to "ID"
    Then verifies that "Asc" arrow is displayed next to "ID"
    Then verifies that the table is sorted in "Asc" order by the "ID" column


  Scenario: TC_35 Super admin should be able to sort look-ups descending order by id
    And selects "20" from the list size options
    When double clicks on arrow button next to "ID"
    Then verifies that "Desc" arrow is displayed next to "ID"
    Then verifies that the table is sorted in "Desc" order by the "ID" column


  Scenario: TC_36 Super admin should be able to sort look-ups ascending order by type
    And selects "20" from the list size options
    When clicks on arrow button next to "TYPE"
    Then verifies that "Asc" arrow is displayed next to "TYPE"
    Then verifies that the table is sorted in "Asc" order by the "TYPE" column


  Scenario: TC_37 Super admin should be able to sort look-ups descending order by type
    And selects "20" from the list size options
    When double clicks on arrow button next to "TYPE"
    Then verifies that "Desc" arrow is displayed next to "TYPE"
    Then verifies that the table is sorted in "Desc" order by the "TYPE" column


  Scenario: TC_38 Super admin should be able to sort look-ups ascending order by name
    And selects "20" from the list size options
    When clicks on arrow button next to "NAME"
    Then verifies that "Asc" arrow is displayed next to "NAME"
    Then verifies that the table is sorted in "Asc" order by the "NAME" column


  Scenario: TC_39 Super admin should be able to sort look-ups descending order by name
    And selects "20" from the list size options
    When double clicks on arrow button next to "NAME"
    Then verifies that "Desc" arrow is displayed next to "NAME"
    Then verifies that the table is sorted in "Desc" order by the "NAME" column


  Scenario: TC_40 Super admin should be able to sort look-ups ascending order by parent id
    And selects "20" from the list size options
    When clicks on arrow button next to "PARENT ID"
    Then verifies that "Asc" arrow is displayed next to "PARENT ID"
    Then verifies that the table is sorted in "Asc" order by the "PARENT ID" column


  Scenario: TC_41 Super admin should be able to sort look-ups descending order by parent id
    And selects "20" from the list size options
    When double clicks on arrow button next to "PARENT ID"
    Then verifies that "Desc" arrow is displayed next to "PARENT ID"
    Then verifies that the table is sorted in "Desc" order by the "PARENT ID" column
