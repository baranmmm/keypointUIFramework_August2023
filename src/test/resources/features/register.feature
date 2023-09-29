@regression
@register
Feature: Register

  Background:
    Given The user goes to talrise homepage
    When the user clicks SIGN UP button

  @ValidCredentials
  Scenario Outline: Register With Valid Credentials

    And the user enters valid "<First Name>","<Last Name>","<LinkedIn>","<Email>","<Password>"
    And the user clicks on button that "I have read and agree to the privacy policy and GDPR."
    And the clicks on button that "CREATE MY ACCOUNT"
    Then the user should be able to see Registered successfully! message
#maili ve linkedini her defasinda degistirmek gerekir
    Examples:
      | First Name                                         | Last Name                                          | LinkedIn                  | Email                                              | Password    |
      | as                                                 | asdas                                              | https://linkedin.com/in/c | h@yo.cc                                            | Test123456! |
      | qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvb | as                                                 | www.linkedin.com/in/co    | g1@yopmais.coc                                     | Test123456! |
      | asdas                                              | fwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvx | www.linkedin.com/in/ch01  | g_@yopmail.clc                                     | Test123456! |
      | a w                                                | Aaa aa and As ss ss                                | www.linkedin.com/in/H05   | gf.a@yopmail.cla                                   | Test123456! |
      | Mr Adem                                            | asdas                                              | www.linkedin.com/in/hh05  | g@yopmail.cla                                      | Test123456! |
      | bedriye                                            | antalyali                                          | www.linkedin.com/in/hd01  | gwertyuiopsslfyhjklzxcvbnmqwertyuiopasdfghjk@yo.co | Test123456! |


  @EmptyCredentials
  Scenario Outline: As a user, I should not be able to create an account with empty credentials
  and should have an error message

    And the user enters empty "<First Name>","<Last Name>","<LinkedIn>","<Email>","<Password>","<ConfirmPassword>"
    And the user clicks on button that "I have read and agree to the privacy policy and GDPR."
    And the clicks on button that "CREATE MY ACCOUNT"
    Then the user should be able to see "<Message>" messages
    Examples:
      | First Name | Last Name | LinkedIn                         | Email           | Password    | ConfirmPassword | Message                           |
      |            | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456! | Test123456!     | Please enter your first name.     |
      | yyy        |           | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456! | Test123456!     | Please enter your last name.      |
      | yyy        | as        |                                  | f1@yopmais.col  | Test123456! | Test123456!     | Please enter your LinkedIn URL.   |
      | yyy        | as        | www.linkedin.com/in/uo           |                 | Test123456! | Test123456!     | Please enter your e-mail address. |
      | yyy        | as        | www.linkedin.com/in/uo           | f1@yopmais.col  |             |                 | Please enter your password.       |
      | as         | asdas     | https://linkedin.com/in/occccccc | dxxxxxxcx@yo.cl | Test123456! |                 | Please confirm your password.     |


  @InvalidCredentials
  Scenario Outline: As a user, I should not be able to create an account with invalid credentials
  and should have an error message

    And the user enters invalid "<First Name>","<Last Name>","<LinkedIn>","<Email>","<Password>","<ConfirmPassword>"
    And the user clicks on button that "I have read and agree to the privacy policy and GDPR."
    And the clicks on button that "CREATE MY ACCOUNT"
    Then the user should be able to see "<Message>" message

    # Linkedin alanina format disi deger girildiginde kabul ediyor linkedin.com/in/ 10.ornek
    # Linkedin name alanina _ yi kabul ederken baska girilen ozel karakterleri kabul etmiyor

    Examples:
      | First Name | Last Name | LinkedIn                         | Email           | Password     | ConfirmPassword | Message                                                                                                  |
      | a          | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456!  | Test123456!     | First name should be 2 characters minimum.                                                               |
      | q_         | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456!  | Test123456!     | Not a valid name! (Only letters)                                                                         |
      | 1_         | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456!  | Test123456!     | Not a valid name! (Only letters)                                                                         |
      | mr.adem    | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456!  | Test123456!     | Not a valid name! (Only letters)                                                                         |
      | yyy        | a         | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456!  | Test123456!     | Last name should be 2 characters minimum.                                                                |
      | yyy        | q_        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456!  | Test123456!     | Not a valid lastname! (Only letters)                                                                     |
      | yyy        | 1_        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456!  | Test123456!     | Not a valid lastname! (Only letters)                                                                     |
      | yyy        | mr.adem   | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456!  | Test123456!     | Not a valid lastname! (Only letters)                                                                     |
      | yyy        | as  aa    | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456!  | Test123456!     | Not a valid lastname! (Only letters)                                                                     |
      | yyy        | as        | linkedin.com/in/us               | f1@dopmais.cos  | Test123456!  | Test123456!     | LinkedIn URL must be a valid LinkedIn URL (https://linkedin.com/in/brucelee/)                            |
      | yyy        | as        | l                                | f1@yopmais.col  | Test123456!  | Test123456!     | LinkedIn URL must be a valid LinkedIn URL (https://linkedin.com/in/brucelee/)                            |
      | yyy        | as        | www.linkedin.com/in/             | f1@yopmais.col  | Test123456!  | Test123456!     | LinkedIn URL must be a valid LinkedIn URL (https://linkedin.com/in/brucelee/)                            |
      | yyy        | as        | www.linkedin.com/in/uo&          | f1@yopmais.col  | Test123456!  | Test123456!     | LinkedIn URL must be a valid LinkedIn URL (https://linkedin.com/in/brucelee/)                            |
      | yyy        | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test12!      | Test12!         | Password must be at least 8 characters long.                                                             |
      | yyy        | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | test123456!  | test123456!     | Password must include at least a lowercase letter, an uppercase letter a number and a special character. |
      | yyy        | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | TEST123456!  | TEST123456!     | Password must include at least a lowercase letter, an uppercase letter a number and a special character. |
      | yyy        | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | TESa!!!!!!   | TESa!!!!!!      | Password must include at least a lowercase letter, an uppercase letter a number and a special character. |
      | yyy        | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test123456   | Test123456      | Password must include at least a lowercase letter, an uppercase letter a number and a special character. |
      | yyy        | as        | www.linkedin.com/in/uo           | f1@yopmais.col  | Test 123456! | Test 123456!    | Password must include at least a lowercase letter, an uppercase letter a number and a special character. |
      | as         | asdas     | https://linkedin.com/in/occccccc | dxxxxxxcx@yo.cl | Test123456!  | Test123456      | Passwords do not match.                                                                                  |

  @InvalidCredentialsAlert
  Scenario Outline: As a user, I should not be able to create an account with invalid credentials
  and should have an alert error message

    And the user enters invalid "<First Name>","<Last Name>","<LinkedIn>","<Email>","<Password>"
    And the user clicks on button that "I have read and agree to the privacy policy and GDPR."
    And the clicks on button that "CREATE MY ACCOUNT"
    Then the user should be able to see alert "<Message>" message

    Examples:
      | First Name                                          | Last Name                                           | LinkedIn               | Email                                               | Password              | Message                                                                                                                                                                                                                                                                                             |
      | qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbd | as                                                  | www.linkedin.com/in/uo | f1@yopmais.col                                      | Test123456!           | size must be between 2 and 50                                                                                                                                                                                                                                                                  |
      | yyy                                                 | qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbd | www.linkedin.com/in/uo | f1@yopmais.col                                      | Test123456!           | size must be between 1 and 50                                                                                                                                                                                                                                                                  |
      | yyy                                                 | as                                                  | www.linkedin.com/in/uo | fwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjaa@yo.cl | Test123456!           | size must be between 6 and 50                                                                                                                                                                                                                                                                |
      | yyy                                                 | as                                                  | www.linkedin.com/in/uo | f1@yopmais.col                                      | Test1234567890123456! | Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:(!@#&()–[{}]:;',?/*~$^+=<>.) & Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:(!@#&()–[{}]:;',?/*~$^+=<>.) |

  @InvalidCredentialsPopUp
  Scenario Outline: As a user, I should not be able to create an account with invalid credentials
  and should have an popup error message

    And the user enters invalid "<First Name>","<Last Name>","<LinkedIn>","<Email>","<Password>"
    And the user clicks on button that "I have read and agree to the privacy policy and GDPR."
    And the clicks on button that "CREATE MY ACCOUNT"
    Then the user should be able to see popup "<Message>" message

    Examples:
      | First Name | Last Name | LinkedIn               | Email         | Password    | Message                                        |
      | yyy        | as        | www.linkedin.com/in/uo | @s.ss         | Test123456! | Email should be 6 characters minimum.          |
      | yyy        | as        | www.linkedin.com/in/uo | @yo.com       | Test123456! | Email must be a valid email (example@mail.com) |
      | yyy        | as        | www.linkedin.com/in/uo | f1yopmais.col | Test123456! | Email must be a valid email (example@mail.com) |
      | yyy        | as        | www.linkedin.com/in/uo | f1@.col       | Test123456! | Email must be a valid email (example@mail.com) |
      | yyy        | as        | www.linkedin.com/in/uo | f1@yopmais.   | Test123456! | Email must be a valid email (example@mail.com) |

  @validPassword
  Scenario Outline: Register With Valid Confirm Password
#maili ve linkedini her defasinda degistirmek gerekir
    And the user enters valid "<First Name>","<Last Name>","<LinkedIn>","<Email>","<Password>","<ConfirmPassword>"
    And the user clicks on button that "I have read and agree to the privacy policy and GDPR."
    And the clicks on button that "CREATE MY ACCOUNT"
    Then the user should be able to see Registered successfully! message
    Examples:
      | First Name | Last Name | LinkedIn                        | Email          | Password    | ConfirmPassword |
      | as         | asdas     | https://linkedin.com/in/ocdcfccc | dxxxxxxx@yo.kl | Test123456! | Test123456!     |


  @visibiltyOfPassword
  Scenario: visibilty password

    And The user clicks eye icon
    And The user enter password
    Then The user should be able to see visibility of password


  @checkBox
  Scenario: checkBox privacy policy and GDPR.

    And The user clicks checkBox
    And The user should be able to select check box
    And The user deselect checkBox
    And The user clicks create my account
    Then When the user diselect check box , "Please confirm that you have read and agree to the Privacy Policy & GDPR." is seen

