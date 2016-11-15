@smokeTest @finance @schedulePayment
Feature: Logging into the Finance site

  Background:

    Given user navigates to login page
    And user enters valid email 'sam.jones@email.com' and password 'password'
    And schedule payment page should be displayed

  Scenario: Message is displayed if Date of Transfer is invalid

    When user clicks submit button with errors
    Then 'Date of transfer is required' error is displayed for Date of Transfer

    When user enters '99', '99' and '2016' into Date of Transfer field
    And user clicks submit button with errors
    Then 'Date of transfer needs to be in a valid format dd/mm/yyyy' error is displayed for Date of Transfer

    When user enters '1', '1' and '2016' into Date of Transfer field
    And user clicks submit button with errors
    Then 'Date of transfer needs to be greater than todays date' error is displayed for Date of Transfer date value

    When user enters '1', '1' and '2099' into Date of Transfer field
    And user clicks submit button with errors
    Then 'Date of transfer cannot be greater than 31 days from today' error is displayed for Date of Transfer date value

    Then driver shutdown at end of test