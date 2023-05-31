Feature: feature to test Login functionality, product functionality and logout functionality

  @sanitytest
  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters the valid <email>
    And clicks on login button
    Then user is navigates to the home page

    Examples: 
      | email                    |
      | "itsmemojaved@gmail.com" |

  @sanitytest
  Scenario Outline: Click the byproduct from MakeUp option
    Given user in on home page
    When user select the from the makeup product
    Then user navigates to new tab of byproduct list page

  @sanitytest
  Scenario Outline: product selection
    Given user is on products page
    When user select the byproduct
    And user navigates to new tab of chosen product page
    When user clicks the add to bag button
    When user clicks the bag icon in the product page
    When user clicks proceed button
    Then user navigates to the choose address page

  @sanitytest
  Scenario Outline: to enter the address for the delivery
    Given user is on address page
    When user clicks the add new address icon
    And user enters the valid <Pincode>
    And user enters the <House number>
    And user enters the <Area name>
    When user click the default address checkbox
    And user enters the <name> in the contact details
    And user enters the <phone number>
    And user enters the <emailID>
    When user clicks the ship to this address button
    Then user navigates to Payment method page for payment

    Examples: 
      | Pincode  |  | House number |  | Area name        |  | name             |  | phone number |  | emailID                  |
      | "613009" |  | "44"         |  | "Srinivasapuram" |  | "Mohammed Javed" |  | "9342375858" |  | "itsmemojaved@gmail.com" |

  @sanitytest
  Scenario Outline: logout the profile
    Given user navigates to profile home page
    When user clicks on logout button
    Then user navigates to home page
