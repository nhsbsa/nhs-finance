@smokeTest  @finance @newtest
Feature: Adding adjustments

  Background:

    Given user navigates to login page
    And user enters valid email 'sam.jones@email.com' and password 'password'
    And schedule payment page should be displayed
    And user enters tomorrows date into Date of Transfer field
    And user clicks on staff
    And user enters '11' and '2010' into Contribution Date field
    And user clicks submit button
    And contributions and payment page is displayed
    And user enters '100.00' into total pensionable pay field
    And user enters '10.00' into employee contributions field
    And user enters '14.00' into employer contributions field

  Scenario: Employers contribution - valid
    When yes is selected on adjustments required
    And user enters '1.00' into employer contributions adjustment field
    Then user clicks next button
