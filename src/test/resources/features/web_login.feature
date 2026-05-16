@web
Feature: Web UI login automation test

  Scenario: Positive login with valid username and password
    Given user opens SauceDemo login page
    When user inputs username "standard_user"
    And user inputs password "secret_sauce"
    And user clicks login button
    Then user should be redirected to product page

  Scenario: Negative login with wrong password
    Given user opens SauceDemo login page
    When user inputs username "standard_user"
    And user inputs password "wrong_password"
    And user clicks login button
    Then user should see login error message

  Scenario: Boundary login with very long username
    Given user opens SauceDemo login page
    When user inputs username "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    And user inputs password "secret_sauce"
    And user clicks login button
    Then user should see login error message