@api
Feature: Dummy API user automation test

  Scenario: Get list of users
    Given user prepares DummyAPI header
    When user sends request to get list of users
    Then API response status code should be 200
    And API response body should contain user data

  Scenario: Get list of tags
    Given user prepares DummyAPI header
    When user sends request to get list of tags
    Then API response status code should be 200
    And API response body should contain tag data

  Scenario: Create new user
    Given user prepares DummyAPI header
    When user sends request to create new user
    Then API response status code should be 200
    And API response body should contain created user id

  Scenario: Get created user by ID
    Given user prepares DummyAPI header
    When user sends request to get created user by id
    Then API response status code should be 200
    And API response body should contain created user email

  Scenario: Update created user
    Given user prepares DummyAPI header
    When user sends request to update created user
    Then API response status code should be 200
    And API response body should contain updated user name

  Scenario: Delete created user
    Given user prepares DummyAPI header
    When user sends request to delete created user
    Then API response status code should be 200
    And API response body should contain deleted user id

  Scenario: Negative create user without required email
    Given user prepares DummyAPI header
    When user sends request to create user without email
    Then API response status code should be 400

  Scenario: Negative create user without first name
    Given user prepares DummyAPI header
    When user sends request to create user without first name
    Then API response status code should be 400

  Scenario: Negative create user with invalid email format
    Given user prepares DummyAPI header
    When user sends request to create user with invalid email
    Then API response status code should be 400

  Scenario: Negative get user with invalid id
    Given user prepares DummyAPI header
    When user sends request to get user with invalid id
    Then API response status code should be 400 or 404

  Scenario: Negative update user with invalid id
    Given user prepares DummyAPI header
    When user sends request to update user with invalid id
    Then API response status code should be 400 or 404

  Scenario: Negative delete user with invalid id
    Given user prepares DummyAPI header
    When user sends request to delete user with invalid id
    Then API response status code should be 400 or 404

  Scenario: Negative get users without app id
    When user sends request to get list of users without app id
    Then API response status code should be 403

  Scenario: Negative get users with invalid app id
    When user sends request to get list of users with invalid app id
    Then API response status code should be 403