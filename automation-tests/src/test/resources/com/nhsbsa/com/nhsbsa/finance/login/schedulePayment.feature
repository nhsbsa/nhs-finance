@smokeTest @finance @schedulePayment
Feature: Logging into the Finance site

  Background:

    Given user navigates to login page
    When user enters valid email 'sam.jones@email.com' and password 'password'
    Then schedule payment page should be displayed


  Scenario: Message is displayed if Date of Transfer is invalid

    When 
    Then driver shutdown at end of test