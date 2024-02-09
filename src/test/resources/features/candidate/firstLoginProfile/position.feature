
  Feature: Position
    Background:
      Given the "candidate" logs in successfully
      When navigates to "Position" page

    Scenario: Candidate should be able to add and save Position
      Then verifies * icon is visible upon Position
      And types "Analyst" in the Position Search Box
      And clicks on a position inside the Suggested Positions list
      Then verifies the selected position is no longer visible inside the list
      Then verifies the selected position is visible under the page
      And clicks on "Next" button
      Then verifies "Your position data has been submitted successfully." alert is seen
      Then verifies landing on "Skill Set" page
      #Then verifies circle next to "Position" on the left menu has a tick symbol
      And clicks on "Back" button
      Then verifies landing on "Position" page
      #And clicks on "Exit" button  !!Save&Exit bugi fixlenecek
      #Then verifies landing on "Dashboard" page
      #And the user navigates "Profile" left menu option
       #Then verifies circle next to "Position" with green tick symbol is visible

    Scenario: Candidate should be able to delete added positions
      When types "Analyst" in the Position Search Box
      And clicks on a position inside the Suggested Positions list
      Then verifies the selected position is visible under the page
      And deletes the added position
#      Then verifies the deleted position is no longer visible under the page
      And types "Analyst" in the Position Search Box
      Then verifies the deleted positions is seen inside the Suggested Position list

#    Scenario: Candidate should not be able to save Position more than 5 or without choosing any  position
#      And clicks on "See More >" button
#      Then verifies "more" positions are visible inside the list
#      And clicks on 5 position from Suggested Positions
#      Then verifies the Suggested Position list is deactivated
#      And clicks on "See Less >" button
#      Then verifies "less" positions are visible inside the list
#      And clicks on "Next" button
#      Then verifies "Your position data has been submitted successfully." alert is seen
#      And clicks on "Back" button
#      And deletes the added "positions"
#      #5 pozisyon kayitli kalirsa sonraki testlerde secemeyecegi icin fail olur.O yuzden sildim
#      And clicks on "Next" button
#      Then verifies "Please choose at least one position" alert is seen
#      And clicks on 1 position from Suggested Positions
#      And clicks on "Next" button



      




