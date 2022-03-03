Feature: Given there is data available
  Scenario: Get all films
    Given There are films available
    When All films are requested
    Then All films should be returned

  Scenario: Get all actors
    Given There are actors available
    When All actors are requested
    Then All available actors should be returned

  Scenario: Get all languages
    Given There are languages available
    When All languages are requested
    Then All languages should be returned

  Scenario: Get specific actor
    Given The specific actor is available
    When The user requests a actor
    Then The actor will be returned

  Scenario: Get specific film
    Given The specific film is available
    When The user requests a film
    Then The film will be returned

  Scenario: Get specific language
    Given The specific language is available
    When The user requests a language
    Then The language will be returned