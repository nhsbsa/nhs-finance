@smokeTest @finance @schedulePayment
Feature: Logging into the Finance site

  Background:

    Given user navigates to login page
    And user enters valid email 'sam.jones@email.com' and password 'password'
    And schedule payment page should be displayed

  Scenario: Error messages are displayed if data is invalid

    # Date of Transfer

    When user clicks submit button with errors
    Then 'Date of transfer is required' error is displayed for Date of Transfer

    Given user enters '99', '99' and '2016' into Date of Transfer field
    When user clicks submit button with errors
    Then 'Date of transfer needs to be in a valid format dd/mm/yyyy' error is displayed for Date of Transfer

    Given user enters '1', '1' and '2016' into Date of Transfer field
    When user clicks submit button with errors
    Then 'Date of transfer needs to be greater than todays date' error is displayed for Date of Transfer date value

    Given user enters '1', '1' and '2099' into Date of Transfer field
    When user clicks submit button with errors
    Then 'Date of transfer cannot be greater than 31 days from today' error is displayed for Date of Transfer date value

    # Payment Contribution

    When user clicks submit button with errors
    Then Error is displayed when Payment Contribution is not set

    # Contribution Date

    When user clicks submit button with errors
    Then 'Payment date must be less than 2 months in the future' error is displayed for Contribution Date
    Then 'Payment month must be between 1 and 12' error is displayed for Contribution Date month
    Then 'Payment year must be after 2001' error is displayed for Contribution Date year

#    When user enters '0' and '2010' into Contribution Date field$
#    Then 'Payment month must be between 1 and 12' error is displayed for Contribution Date year

#    When user enters '99' and '2010' into Contribution Date field$
#    Then 'Payment month must be between 1 and 12' error is displayed for Contribution Date year

    Given user enters '11' and '2000' into Contribution Date field
    When user clicks submit button with errors
    Then 'Payment year must be after 2001' error is displayed for Contribution Date year

    Given user enters '11' and '2099' into Contribution Date field
    When user clicks submit button with errors
    Then 'Payment date must be less than 2 months in the future' error is displayed for Contribution Date

    # Success

    Given user enters tomorrows date into Date of Transfer field
    And user clicks on staff
    And user enters '11' and '2010' into Contribution Date field
    When user clicks submit button

    Then driver shutdown at end of test