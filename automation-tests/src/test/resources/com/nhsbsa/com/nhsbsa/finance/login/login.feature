@smokeTest @finance @login
Feature: Logging into the finance site

  Background:
    Given user navigates to finance login page

  Scenario: finance login page should be displayed
    Then finance login page should be displayed

  Scenario: Member successfully logs in

    When user enters valid email 'sam.jones@email.com' and password 'password'
    Then employer account info page should be displayed

  Scenario: Error message is displayed for invalid user

    When user enters invalid email 'imposter@email.com' and password 'password'
    Then error text should be displayed on finance login page

  Scenario: Entering Delete from table SQL Injection into the email field will fail

    When user enters invalid email 'DELETE FROM FINANCE_USER WHERE USERNAME = sam.jones@email.com;' and password 'password'
    Then error text should be displayed on finance login page

  Scenario: Entering Select * from table SQL Injection into the email field will fail

    When user enters invalid email 'SELECT * FROM FINANCE_USER WHERE USERNAME = sam.jones@email.com;SELECT *FROM FINANCE_USER WHERE FIRST_NAME=Sam;' and password 'password'
    Then error text should be displayed on finance login page

  Scenario: Finance login page should pass accessibility checker

    Then finance login page should pass accessibility checker
