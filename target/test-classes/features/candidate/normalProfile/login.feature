@regression
@login
Feature: Login Feature

  @wip
  Scenario: Login with Valid Credentials
    Given the user provides valid credentials
    When the user clicks on login button
    Then the user should be able to logged in successfully

  @tc2-4
  Scenario Outline: Login with invalid Credentials
    Given the user enters invalid "<Email>","<Password>"
    When the user clicks on login button
    Then the user should see "Username or password not correct" message

    Examples:
      | Email                   | Password     |
      | aynuravci41@yopmail.com | Test123456!  |
      | aynuravci@yopmail.com   | Test1234567! |
      | aynuravci23@yopmail.com | Test1234567! |

  @tc5-8
  Scenario Outline: Login with invalid Credentials
    Given the user enters invalid "<Email>","<Password>"
    When the user clicks on login button
    Then the user should see "<Message>"

    Examples:
      | Email                 | Password    | Message                                      |
      | @yopmail.com          | Test123456! | Please enter a valid e-mail address.         |
      |                       | Test123456! | Please enter your e-mail address.            |
      | aynuravci@yopmail.com |             | Please enter your password.                  |
      | aynuravci@yopmail.com | 123         | Password must be at least 8 characters long. |


  @tc-9
  Scenario: Test that Email and Password are written in the email and password boxes.
    Then the user should see "Email" text in the email box
    Then the user should see "Password" text in the password box

  @tc-10
  Scenario: Test that visible "Need An Account?" text in front of "SIGN UP" link
    Then the user should see "Need An Account" text

  @tc-11
  Scenario:Test that the user clicks "Forgot Password?" link then the user should navigate to "FORGOT YOUR PASSWORD?" page
    When user clicks Forgot Password link
    Then user should navigate to forgot-password page

  @tc-12
  Scenario: Test that "Forgot Password?" visible
    Then user should see "FORGOT PASSWORD" text

  @tc-13
  Scenario: Test that the user clicks "SIGN UP" link then the user should navigate to "Sign Up" page
    When the user clicks SIGN UP link
    Then the user should navigate to Sign Up page

  @tc-14
  Scenario: Test that "SIGN UP" visible
    Then the user should see SIGN UP message

  @tc-15
  Scenario: Test that an eye icon is visible in the password textbox
    Then the user should see an eye icon in the password textbox

  @tc-16
  Scenario: Test that the entered password appears when the eye button is clicked.
    When the user clicks on password
    And the user enters "Test123456!"
    And the user clicks the eye icon in the password box
    Then the user should see "Test123456!" as the password