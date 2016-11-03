@smokeTest
Feature: Logging into the Finance site

  Background:

    Given user navigates to finance start page
    And finance start page is displayed
    And click start now button on finance start page
    And finance login page is displayed

  Scenario: Error message is displayed for invalid user

    When user enters invalid email 'imposter@email.com' and password 'password'
    Then error text should be displayed on finance login page

  Scenario: User clicks logout on finance login page

    When user clicks on logout button in finance login page
    Then logout text should be displayed on finance login page

  #Scenario: FUTURE!!! Valid username/password entered go to security page

    #When user enters valid email 'sam.jones@email.com' and password 'password'
    #Then security page is displayed