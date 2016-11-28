@smokeTest @finance @contributionPayment
Feature: Contributions and payment

  Background:

    Given user navigates to login page
    And user enters valid email 'sam.jones@email.com' and password 'password'
    And schedule payment page is displayed
    And user enters tomorrows date into Date of Transfer field
    And user clicks on staff
    And user enters '11' and '2010' into Contribution Date field
    And submit button is clicked
    And contributions and payment page is displayed

  Scenario: Error messages are displayed if data is invalid

    # Total Pensionable Pay

    When '-1' is entered into into Total Pensionable Pay
    And submit button is clicked
    Then Total Pensionable Pay shows 'Enter a numeric value between 1 - 99,999,999.99' validation error

    When '0' is entered into into Total Pensionable Pay
    And submit button is clicked
    Then Total Pensionable Pay shows 'Enter a numeric value between 1 - 99,999,999.99' validation error

    When '100000000' is entered into into Total Pensionable Pay
    And submit button is clicked
    Then Total Pensionable Pay shows 'Enter a numeric value between 1 - 99,999,999.99' validation error

    When '' is entered into into Total Pensionable Pay
    And submit button is clicked
    Then Total Pensionable Pay shows 'Total pensionable pay is required' validation error

    When 'xyz' is entered into into Total Pensionable Pay
    And submit button is clicked
    Then Total Pensionable Pay shows 'Total pensionable pay is required' validation error

    # Employee Contributions

    When '-1' is entered into into Employee Contributions
    And submit button is clicked
    Then Employee Contributions shows 'Enter a numeric value between 1 - 99,999,999.99' validation error

    # Employer Contributions

    When '-1' is entered into into Employer Contributions
    And submit button is clicked
    Then Employer Contributions shows 'Enter a numeric value between 1 - 99,999,999.99' validation error

    # Employee Added Years

    When '-1' is entered into into Employee Added Years
    And submit button is clicked
    Then Employee Added Years shows 'Enter a numeric value between 1 - 99,999,999.99' validation error

    # Additional Pension

    When '-1' is entered into into Additional Pension
    And submit button is clicked
    Then Additional Pension shows 'Enter a numeric value between 1 - 99,999,999.99' validation error

    # ERRBO

    When '-1' is entered into into ERRBO
    And submit button is clicked
    Then ERRBO shows 'Enter a numeric value between 1 - 99,999,999.99' validation error