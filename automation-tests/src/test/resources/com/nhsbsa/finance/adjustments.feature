@smokeTest  @finance @newTest
Feature: Adding adjustments

  Background:

    Given user navigates to login page
    And user enters valid email 'sam.jones@email.com' and password 'password'
    And schedule payment page should be displayed
    And user enters tomorrows date into Date of Transfer field
    And user clicks on staff
    And user enters 'November' and '2010' into Contribution Date field
    And user clicks submit button
    And contributions and payment page is displayed
    And user enters '100.00' into total pensionable pay field
    And user enters '10.00' into employee contributions field
    And user enters '14.00' into employer contributions field

  Scenario: Adjustment period - valid
    When yes is selected on adjustments required
    And user enters 'December' into adjustment period month field
    And user enters '2010' into adjustment period year field
    And user enters '1.00' into employee contributions adjustment field
    And user clicks next button
    Then feature is not yet available page should be displayed

  Scenario: Employee contributions adjustment - valid
    When yes is selected on adjustments required
    And user enters '1.00' into employee added years adjustment field
    And user clicks next button
    Then feature is not yet available page should be displayed

  Scenario: Employee contributions adjustment - invalid
    When yes is selected on adjustments required
    And user enters '0.50' into employee contributions adjustment field
    And user clicks next button with errors
    Then 'Employee contribution - amount you have entered is incorrect' error is displayed for employee contributions adjustment

  Scenario: Employers contribution adjustment - valid
    When yes is selected on adjustments required
    And user enters '1.00' into employer contributions adjustment field
    Then user clicks next button
    And feature is not yet available page should be displayed

  Scenario: Employers contribution adjustment - invalid
    When yes is selected on adjustments required
    And user enters '0.50' into employer contributions adjustment field
    And user clicks next button with errors
    Then 'Employers contribution - amount you have entered is incorrect' error is displayed for employer contribution adjustment

  Scenario: Employee added years adjustment - valid
    When yes is selected on adjustments required
    And user enters '1.00' into employee added years adjustment field
    And user clicks next button
    Then feature is not yet available page should be displayed

  Scenario: Employee added years adjustment - invalid
    When yes is selected on adjustments required
    And user enters '0.50' into employee added years adjustment field
    And user clicks next button with errors
    Then 'Employee added years - amount you have entered is incorrect' error is displayed for employee added years adjustment

  Scenario: Additional pension adjustment - valid
    When  yes is selected on adjustments required
    And user enters '1.00' into additional pension adjustment field
    And user clicks next button
    Then feature is not yet available page should be displayed

  Scenario: Additional pension adjustment - invalid
    When yes is selected on adjustments required
    And user enters '0.50' into additional pension adjustment field
    And user clicks next button with errors
    Then 'Additional pension - amount you have entered is incorrect' error is displayed for additional pension adjustment

  Scenario: ERRBO adjustment - valid
    When yes is selected on adjustments required
    And user enters '1.00' into errbo adjustment field
    Then user clicks next button with errors
    And feature is not yet available page should be displayed

  Scenario: ERRBO adjustment - invalid
    When yes is selected on adjustments required
    And user enters '0.50' into errbo adjustment field
    And user clicks next button with errors
    Then 'ERRBO - amount you have entered is incorrect' error is displayed for errbo adjustment