Feature: Place bet

Scenario: As a WH Customer I want the ability to place a bet on a English Premier League event
    Given User navigates to "http://sports.williamhill.com/betting/en-gb"
    And User navigate to "football" event
    When User selects "Stoke" "Arsenal" event
    And place a "£0.05" bet for the "home" team to "Win"
    And assert the odds and returns offered