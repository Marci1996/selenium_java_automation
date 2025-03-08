Feature: login/logout

  Scenario: Log in with valid credentials

    Then User accepts cookies
    And User verifies that home page is visible successfully
    And User clicks on "Signup / Login" button from top menu
    Then User verifies that Login to your account is visible
    Then User enters "valid" email address and password
    And User clicks "login-button"
    Then User verifies that Logged in as username is visible


  Scenario: Log in with incorrect email and password

    Then User accepts cookies
    And User clicks on "Signup / Login" button from top menu
    Then User enters "invalid" email address and password
    And User clicks "login-button"

  Scenario: Register User

    Then User accepts cookies
    And User clicks on "Signup / Login" button from top menu
    And Description about the option to create new sign up visible
    And User enters the signUp credentials
    And User clicks "SignUp button"
 #   Then Verifies that ENTER ACCOUNT INFORMATION description is visible



