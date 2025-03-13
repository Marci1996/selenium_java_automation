Feature: login/logout

  Scenario: Log in with valid credentials

    Given User accepts cookies
    And User verifies that home page is visible successfully
    When User clicks on "Signup / Login" button from top menu
    Then User verifies that Login to your account is visible
    When User enters "valid" email address and password
    And User clicks "login-button"
    Then User verifies that Logged in as username is visible


  Scenario: Log in with incorrect email and password

    Given User accepts cookies
    When User clicks on "Signup / Login" button from top menu
    And User enters "invalid" email address and password
    And User clicks "login-button"


  Scenario: Log out user
    Given User accepts cookies
    When User clicks on "Signup / Login" button from top menu
    When User enters "valid" email address and password
    And User clicks "login-button"
    And User clicks "logout-button"

  Scenario: Register User

    Given User accepts cookies
    When User clicks on "Signup / Login" button from top menu
    Then Description about the option to create new sign up visible
    When User enters the signUp credentials
    And User clicks "signup-button"
 #   Then Verifies that ENTER ACCOUNT INFORMATION description is visible
    When User enters the following information within the registration form
      | Title         | Mr.       |
      | name          | Smith     |
      | password      | password  |
      | Date of birth | 1.11.1998 |
    And User marks the checkbox with "Sign up for our newsletter!" name
    And User marks the checkbox with "Receive special offers from our partners!" name
    And User fills the following details as well within the registration form
      | first_name    | John            |
      | last_name     | Smith           |
      | company       | Smith@gmail.com |
      | address1      | address1        |
      | address2      | address2        |
      | country       | Hungary         |
      | state         | noState         |
      | city          | Budapest        |
      | zipcode       | 123             |
      | mobile_number | 12345678        |
    And User clicks on create account button