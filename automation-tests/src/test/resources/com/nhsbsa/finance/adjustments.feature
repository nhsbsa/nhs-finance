@smokeTest  @finance @adjustments
Feature: Adding adjustments

  Background:

    Given user navigates to login page
    And user enters valid email 'sam.jones@email.com' and password 'password'
    And schedule payment page is displayed
    And tomorrows date is entered into Date of Transfer
    And staff radio button is clicked
    And 'November' and '2010' is entered into Contribution Date
    And submit button is clicked
    And contributions and payment page is displayed
    And '100.00' is entered into into Total Pensionable Pay
    And '10.00' is entered into into Employee Contributions
    And '14.00' is entered into into Employer Contributions

  Scenario: Adjustments inputs - invalid

    When submit button is clicked
    Then Error message 'Adjustments is required' is displayed for Adjustment Option

    When yes radio button is clicked for adjustments required
    And 'December' is entered into Adjustment Period month
    And '2010' is entered into Adjustment Period year
    And submit button is clicked
    Then Error message 'At least one value is required if adding adjustments' is displayed for Adjustment Section

    When 'Sept' is entered into Adjustment Period month
    And '' is entered into Adjustment Period year
    And '1.00' is entered into Employee Added Years adjustment
    And submit button is clicked
    Then Error message 'Adjustment period in format Month and Year is required.' is displayed for Adjustment Period

    When '' is entered into Adjustment Period month
    And '2010' is entered into Adjustment Period year
    And '1.00' is entered into Employee Added Years adjustment
    And submit button is clicked
    Then Error message 'Adjustment period in format Month and Year is required.' is displayed for Adjustment Period

    When 'Sept' is entered into Adjustment Period month
    And '2010' is entered into Adjustment Period year
    And '1.00' is entered into Employee Added Years adjustment
    And submit button is clicked
    Then Error message 'Adjustment period in format Month and Year is required.' is displayed for Adjustment Period

    When '#$?/.,' is entered into Adjustment Period month
    And '-2010' is entered into Adjustment Period year
    And '1.00' is entered into Employee Added Years adjustment
    And submit button is clicked
    Then Error message 'Adjustment period in format Month and Year is required.' is displayed for Adjustment Period

    When 'January' is entered into Adjustment Period month
    And '2030' is entered into Adjustment Period year
    And '1.00' is entered into Employer Contributions adjustment
    And submit button is clicked
    Then Error message 'Adjustment period cannot be for a current or future month' is displayed for Adjustment Period

    When '0.50' is entered into Employee Contributions adjustment
    And submit button is clicked
    Then Error message 'Employee contribution - amount you have entered is incorrect' is displayed for Employee Contributions adjustment

    When '0.50' is entered into Employer Contributions adjustment
    And submit button is clicked
    Then Error message 'Employers contribution - amount you have entered is incorrect' is displayed for Employer Contributions adjustment

    When '0.50' is entered into Employee Added Years adjustment
    And submit button is clicked
    Then Error message 'Employee added years - amount you have entered is incorrect' is displayed for Employee Added Years adjustment

    When '0.50' is entered into Additional Pension adjustment
    And submit button is clicked
    Then Error message 'Additional pension - amount you have entered is incorrect' is displayed for Additional Pension adjustment

    When '0.50' is entered into ERRBO adjustment
    And submit button is clicked
    Then Error message 'ERRBO - amount you have entered is incorrect' is displayed for ERRBO adjustment

    When '0' is entered into Employer Contributions adjustment
    And submit button is clicked
    Then Error message 'Employers contribution - amount you have entered is incorrect' is displayed for Employer Contributions adjustment

  Scenario: Adjustment period - valid

    When yes radio button is clicked for adjustments required
    And 'December' is entered into Adjustment Period month
    And '2010' is entered into Adjustment Period year
    And '1.00' is entered into Employee Contributions adjustment
    And '1.00' is entered into Employer Contributions adjustment
    And '1.00' is entered into Employee Added Years adjustment
    And '1.00' is entered into Additional Pension adjustment
    And '1.00' is entered into ERRBO adjustment
    And submit button is clicked
    Then feature is not yet available page is displayed
