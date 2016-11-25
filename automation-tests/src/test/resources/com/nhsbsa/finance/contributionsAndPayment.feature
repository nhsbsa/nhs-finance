@smokeTest @finance @contributionPayment
Feature: Logging into the Finance site

  Background:

    Given user navigates to login page
    And user enters valid email 'sam.jones@email.com' and password 'password'
    And schedule payment page should be displayed
    And user enters tomorrows date into Date of Transfer field
    And user clicks on staff
    And user enters '11' and '2010' into Contribution Date field
    And user clicks schedule submit button
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
    Then Total Pensionable Pay shows 'Total Pensionable Pay is required' validation error

    When 'xyz' is entered into into Total Pensionable Pay
    And submit button is clicked
    Then Total Pensionable Pay shows 'Total Pensionable Pay is required' validation error




#    Given user enters '0' into Total Pensionable Pay field
#    When user clicks contribution submit button with errors
#    Then 'Total Pensionable Pay can only be a numeric value between 1 - 99,999,999.99
#
#    Given user enters '125.321' into Total Pensionable Pay field
#    When user clicks contribution submit button with errors
#    Then 'Total Pensionable Pay can only be a numeric value between 1 - 99,999,999.99
#
#    Given user enters '' into Total Pensionable Pay field
#    When user clicks contribution submit button with errors
#    Then 'Total Pensionable Pay is required

    # Employee Contributions

#    Given user enters '0' into Employee Contribution field
#    When user clicks contribution submit button with errors
#    Then 'Employee's contribution can only be a numeric value between 1 - 99,999,999.99
#
#    Given user enters '125.321' into Employee Contribution field
#    When user clicks contribution submit button with errors
#    Then 'Employee's contribution can only be a numeric value between 1 - 99,999,999.99
#
#    Given user enters '' into Employee Contribution field
#    When user clicks contribution submit button with errors
#    Then 'Employee's Contribution is required
#
#    Given user enters '1000' into Total Pensionable Pay field
#    And  user enters '2000' into Employee Contribution field
#    When user clicks contribution submit button with errors
#    Then 'Employee's Contribution needs to be within 5% and 14.5% of the Total Pensionable Pay

    # Employee Added Years

#    Given user enters '0' into Employee Added Years field
#    When user clicks contribution submit button with errors
#    Then 'Employee's Added Years can only be a numeric value between 1 - 99,999,999.99
#
#    Given user enters '125.321' into Employee Added Years field
#    When user clicks contribution submit button with errors
#    Then 'Employee's Added Years can only be a numeric value between 1 - 99,999,999.99

    # Need test or null Added years not to error

    # Employee Additional Pension

#    Given user enters '0' into Additional Pension field
#    When user clicks contribution submit button with errors
#    Then 'Additional Pension can only be a numeric value between 1 - 99,999,999.99
#
#    Given user enters '125.321' into Additional Pension field
#    When user clicks contribution submit button with errors
#    Then 'Additional Pension can only be a numeric value between 1 - 99,999,999.99

    # Need test or null Additional Pension not to error

    # Employee Errbo

#    Given user enters '0' into Errbo field
#    When user clicks contribution submit button with errors
#    Then 'ERRBO can only be a numeric value between 1 - 99,999,999.99
#
#    Given user enters '125.321' into Errbo field
#    When user clicks contribution submit button with errors
#    Then 'ERRBO can only be a numeric value between 1 - 99,999,999.99

    # Need test or null Errbo not to error

    # Employer Contributions

#    Given user enters '0' into Employer Contribution field
#    When user clicks contribution submit button with errors
#    Then 'Employer's contribution can only be a numeric value between 1 - 99,999,999.99
#
#    Given user enters '125.321' into Employer Contribution field
#    When user clicks contribution submit button with errors
#    Then 'Employer's contribution can only be a numeric value between 1 - 99,999,999.99
#
#    Given user enters '' into Employer Contribution field
#    When user clicks contribution submit button with errors
#    Then 'Employer's Contribution is required
#
#    Given user enters '1000' into Total Pensionable Pay field
#    And  user enters '500' into Employer Contribution field
#    When user clicks contribution submit button with errors
#    Then 'Employer's Contribution cannot be less than 14% of the Total Pensionable Pay

    # Success when AddedYears, AdditionalPension and Errbo fields are left blank

#    Given user enters '5000' into Total Pensionable Pay field
#    And user enters '4995' into Employee Contribution field
#    And user enters '' into Employee Added Years field
#    And user enters '' into Additional Pension field
#    And user enters '' into Errbo field
#    And user enters '4990' into Employer Contribution field
#    When user clicks submit button

    # Success for all fields

#    Given user enters '5000' into Total Pensionable Pay field
#    And user enters '4995' into Employee Contribution field
#    And user enters '100' into Employee Added Years field
#    And user enters '50' into Additional Pension field
#    And user enters '10' into Errbo field
#    And user enters '4990' into Employer Contribution field
#    When user clicks submit button