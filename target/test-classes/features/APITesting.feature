Feature: Testing Bike API for City Frankfurt

  Scenario Outline: User to verify city as Frankfurt and return response of its corresponding latitude and longitude

    Given User sets the base API request <URL>
    When User sends the API request to get all bike info
    Then User validates the response status is <code>
    Examples:
      |URL                                  |code|
      |https://api.citybik.es/v2/networks   |200 |