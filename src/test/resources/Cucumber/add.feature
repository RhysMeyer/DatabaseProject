Feature: There's an entry to add

  Scenario: Add a Film
    Given Have a valid film to add
    When We add the new Film
    Then The new Film should be added and a saved message recieved
