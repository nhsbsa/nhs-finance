@smokeTest @finance @contributionPayment
Feature: Contributions and payment

  Background:

    Given user navigates to login page
    And user enters valid email 'sam.jones@email.com' and password 'password'
    And schedule payment page is displayed
    And tomorrows date is entered into Date of Transfer
    And staff radio button is clicked
    And 'November' and '2010' is entered into Contribution Date
    And submit button is clicked
    And contributions and payment page is displayed
    And page is in Welsh

  Scenario: Error messages are displayed if data is invalid

    # Total Pensionable Pay

    When '-1' is entered into into Total Pensionable Pay
    And submit button is clicked
    Then Error message 'Cyfanswm cyflog pensiynadwy - swm a nodwyd gennych yn anghywir' is displayed for Total Pensionable Pay

    When '0' is entered into into Total Pensionable Pay
    And submit button is clicked
    Then Error message 'Cyfanswm cyflog pensiynadwy - swm a nodwyd gennych yn anghywir' is displayed for Total Pensionable Pay

    When '100000000' is entered into into Total Pensionable Pay
    And submit button is clicked
    Then Error message 'Cyfanswm cyflog pensiynadwy - swm a nodwyd gennych yn anghywir' is displayed for Total Pensionable Pay

#    When '' is entered into into Total Pensionable Pay
#    And submit button is clicked
#    Then Error message 'Total pensionable pay is required' is displayed for Total Pensionable Pay

#    When 'xyz' is entered into into Total Pensionable Pay
#    And submit button is clicked
#    Then Error message 'Total pensionable pay is required' is displayed for Total Pensionable Pay

    # Employee Contributions

    When '-1' is entered into into Employee Contributions
    And submit button is clicked
    Then Error message 'Gweithwyr cyfraniad - swm a nodwyd gennych yn anghywir' is displayed for Employee Contributions

    When '0' is entered into into Employee Contributions
    And submit button is clicked
    Then Error message 'Gweithwyr cyfraniad - swm a nodwyd gennych yn anghywir' is displayed for Employee Contributions

    # Employer Contributions

    When '-1' is entered into into Employer Contributions
    And submit button is clicked
    Then Error message 'Cyflogwyr cyfraniad - swm a nodwyd gennych yn anghywir' is displayed for Employer Contributions

    When '0' is entered into into Employer Contributions
    And submit button is clicked
    Then Error message 'Cyflogwyr cyfraniad - swm a nodwyd gennych yn anghywir' is displayed for Employer Contributions

    # Employee Added Years

    When '-1' is entered into into Employee Added Years
    And submit button is clicked
    Then Error message 'Ychwanegodd Gweithwyr mlynedd - swm a nodwyd gennych yn anghywir' is displayed for Employee Added Years

    When '0' is entered into into Employee Added Years
    And submit button is clicked
    Then Error message 'Ychwanegodd Gweithwyr mlynedd - swm a nodwyd gennych yn anghywir' is displayed for Employee Added Years

    # Additional Pension

    When '-1' is entered into into Additional Pension
    And submit button is clicked
    Then Error message 'Pensiwn ychwanegol - swm a nodwyd gennych yn anghywir' is displayed for Additional Pension

    When '0' is entered into into Additional Pension
    And submit button is clicked
    Then Error message 'Pensiwn ychwanegol - swm a nodwyd gennych yn anghywir' is displayed for Additional Pension

    # ERRBO

    When '-1' is entered into into ERRBO
    And submit button is clicked
    Then Error message 'ERRBO - swm a nodwyd gennych yn anghywir' is displayed for ERRBO

    When '0' is entered into into ERRBO
    And submit button is clicked
    Then Error message 'ERRBO - swm a nodwyd gennych yn anghywir' is displayed for ERRBO
