@smokeTest @finance @schedulePayment
Feature: Schedule a payment

  Background:

    Given user navigates to login page
    And user enters valid email 'sam.jones@email.com' and password 'password'
    And schedule payment page is displayed

  Scenario: Error messages are displayed if data is invalid

    # Date of Transfer

    When submit button is clicked
    Then Error message 'Date of transfer is required' is displayed for Date of Transfer

    Given '99', '99' and '2016' is entered into Date of Transfer
    When submit button is clicked
    Then Error message 'Date of transfer needs to be in a valid format dd/mm/yyyy' is displayed for Date of Transfer

    Given '1', '1' and '2016' is entered into Date of Transfer
    When submit button is clicked
    Then Error message 'Date of transfer needs to be greater than todays date' is displayed for Date of Transfer date value

    Given '1', '1' and '2099' is entered into Date of Transfer
    When submit button is clicked
    Then Error message 'Date of transfer cannot be greater than 31 days from today' is displayed for Date of Transfer date value

    # Payment Contribution

    When submit button is clicked
    Then Error message 'Contribution payment is required' is displayed for Contribution Payment

    # Contribution Date

    When submit button is clicked
    Then Error message 'What month is this payment for? is required' is displayed for Contribution Date

    When '0' and '2010' is entered into Contribution Date
    And submit button is clicked
    Then Error message 'What month is this payment for? month must be between 1 and 12, year must be 2001 onwards' is displayed for Contribution Date

    When '99' and '2010' is entered into Contribution Date
    And submit button is clicked
    Then Error message 'What month is this payment for? month must be between 1 and 12, year must be 2001 onwards' is displayed for Contribution Date

    Given '11' and '2099' is entered into Contribution Date
    When submit button is clicked
    Then Error message 'What month is this payment for? date must be less than 2 months in the future' is displayed for Contribution Date

    # Success

  Scenario: No error messages are displayed if data is valid

    Given tomorrows date is entered into Date of Transfer
    And staff radio button is clicked
    And '11' and '2010' is entered into Contribution Date
    When submit button is clicked