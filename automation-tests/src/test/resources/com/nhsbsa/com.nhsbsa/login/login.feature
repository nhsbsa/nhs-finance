@smokeTest
Feature: Logging into the employer site

  Scenario: Login scenario test for Employer

    Given navigate to employer login page
    When employer logged in using username as userA and password as password
    Then employer home page should be displayed

    Given navigate to invalid employer login page
    Then employer home page should be displayed

    Given navigate to employer login page
    Then employer login page should pass accessibility checker