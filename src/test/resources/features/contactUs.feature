Feature: contact us

  Scenario: Contact us form

    Then User accepts cookies
    And User verifies that home page is visible successfully
    And User clicks on "Contact us" button from top menu
   # Then User verifies that Get In Touch description is visible

    Then User enters the following information within the contact page form
      | name    | value1           |
      | email   | value2@gmail.com |
      | subject | value3           |
      | message | value4           |

    And User uploads a file
    And User clicks on the okay button from the form
    Then User accepts the alert window
    And Successful message about the form fill
    And User clicks on "Home" button from top menu
    #And User verifies that home page is visible successfully


