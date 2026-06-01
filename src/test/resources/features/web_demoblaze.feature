@web
Feature: DemoBlaze web automation test

  Scenario: User can view product list on homepage
    Given user opens DemoBlaze homepage
    Then user should see product list

  Scenario: User can sign up with valid data
    Given user opens DemoBlaze homepage
    When user signs up with new username and password
    Then sign up should be successful

  Scenario: User can login with valid credential
    Given user opens DemoBlaze homepage
    When user logs in with valid credential
    Then username should be displayed on homepage

  Scenario: User cannot login with invalid password
    Given user opens DemoBlaze homepage
    When user logs in with invalid password
    Then error alert should be displayed

  Scenario: User can add product to cart
    Given user opens DemoBlaze homepage
    When user selects a product
    And user adds product to cart
    Then product should be added to cart

  Scenario: User can checkout product successfully
    Given user opens DemoBlaze homepage
    When user selects a product
    And user adds product to cart
    And user opens cart page
    And user places order with valid customer data
    Then purchase should be successful