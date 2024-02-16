@regression
Feature: language

  Background:
    Given the "candidate" logs in successfully
    And the user navigates "Profile" left menu option
    And the user clicks on <"Language"> button

@L1
  Scenario:Test that you can click to select all suggested fields without any number limitation on the selected screen. Test undo all selected areas by pressing the multiply button.

    When Select all language field
    Then Verify that all language fields are displayed on the selected screen
    When press the language cross button above all fields
    Then Verify that you have retrieved all language fields

@L2
  Scenario Outline:Test that you can write  something to Type to search search box and it should be retrieve related data.

    When The user comes to Type to search  box area and write "<data>" in it (language)
    Then Verify that it retrieve all related data "<data>" about language fields
    Examples:
      | data |
      | E    |
      | C    |
      | c    |

@L3
  Scenario Outline:Test that you can not write character or nonrelative text to search search box and it should be empty related data.

    When The user comes to Type to search  box area and write "<character or nonrelative Text>" in it (language)
    Then Verify that it retrieve empty data about language fields
    Examples:
      | character or nonrelative Text |
      | 12312                         |
      | @2131)                        |
      | hfshdf                        |
      | Aaaaaa                        |

@L4
# Garza@yopmail.com kullanicisinda backend tarafinda her bir language alaninda birden fazla secim yapabiliyoruz ve bu backend tarafindan bize hata vermiyor
# ayni kullanici ile UI tarafindan language eklemeye calistigimizda ve save butonunda tikladigimizda 500 hata kodu aliyoruz ve @L4 @L5 tesleri gecmiyor
# Ama farkli bir canditade kullanicisi ile giris yapildinda @L4 @L5 tesleri geciyor.
  Scenario: User should be able to choose "Proficiency Years" for every fields, save and change them
    When The user select one of the language field
    And The user select one of the proficiency
    And The user clicks save button
    Then The user see  alert "Your language data has been submitted successfully."
    And The user change  proficiency
    Then The user see after saved proficiency
@L5
  Scenario: The user clicks on the "SAVE" button with some language fields,
  they should see the message "Your language data has been submitted successfully" and
  click "CANCEL" button and  delete last fields until saved fields.
    When The user select one of the language field
    And The user select one of the proficiency
    And The user clicks save button
    Then The user see  alert "Your language data has been submitted successfully."
    And The user select one of the language field
    And The user click language CANCEL button
    Then the user should see until language saved fields