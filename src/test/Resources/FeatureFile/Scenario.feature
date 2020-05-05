Feature: user should be able to able to shortlist the desired vehicles
@one
  Scenario: adding vehicles to wishlist
    Given the user has logged in to the carGiant portal
    When he searches for "audi","bmw" and "mercedes" car manufacturers and shortlist the desired models
    And  navigates to the wishlist
    Then he should be able to find all the short listed cars
    And he should be able to edit the list and assert the changes

