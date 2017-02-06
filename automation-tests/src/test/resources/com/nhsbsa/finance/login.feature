@smokeTest @finance @login
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

  Scenario: User successfully logs in

    When user enters valid email 'sam.jones@email.com' and password 'password'
    Then schedule payment page is displayed
    Then driver shutdown at end of test

  Scenario: Entering Delete from table SQL Injection into the email field will fail
`
    When user enters invalid email 'DELETE FROM FINANCE_USER WHERE USERNAME = sam.jones@email.com;' and password 'password'
    Then error text should be displayed on finance login page

  Scenario: Entering Select * from table SQL Injection into the email field will fail

    When user enters invalid email 'SELECT * FROM FINANCE_USER WHERE USERNAME = sam.jones@email.com;SELECT *FROM FINANCE_USER WHERE FIRST_NAME=Sam;' and password 'password'
    Then error text should be displayed on finance login page

  Scenario: Finance login page should pass accessibility checker

    Then finance login page should pass accessibility checker
    Then driver shutdown at end of test