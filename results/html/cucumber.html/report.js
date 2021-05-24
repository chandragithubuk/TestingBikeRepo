$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/TestingBikeAPI/src/test/resources/features/APITesting.feature");
formatter.feature({
  "line": 1,
  "name": "Testing Bike API for City Frankfurt",
  "description": "",
  "id": "testing-bike-api-for-city-frankfurt",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "User to verify city as Frankfurt and return response of its corresponding latitude and longitude",
  "description": "",
  "id": "testing-bike-api-for-city-frankfurt;user-to-verify-city-as-frankfurt-and-return-response-of-its-corresponding-latitude-and-longitude",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User sets the base API request \u003cURL\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User sends the API request to get all bike info",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User validates the response status is \u003ccode\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "testing-bike-api-for-city-frankfurt;user-to-verify-city-as-frankfurt-and-return-response-of-its-corresponding-latitude-and-longitude;",
  "rows": [
    {
      "cells": [
        "URL",
        "code"
      ],
      "line": 9,
      "id": "testing-bike-api-for-city-frankfurt;user-to-verify-city-as-frankfurt-and-return-response-of-its-corresponding-latitude-and-longitude;;1"
    },
    {
      "cells": [
        "https://api.citybik.es/v2/networks",
        "200"
      ],
      "line": 10,
      "id": "testing-bike-api-for-city-frankfurt;user-to-verify-city-as-frankfurt-and-return-response-of-its-corresponding-latitude-and-longitude;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "User to verify city as Frankfurt and return response of its corresponding latitude and longitude",
  "description": "",
  "id": "testing-bike-api-for-city-frankfurt;user-to-verify-city-as-frankfurt-and-return-response-of-its-corresponding-latitude-and-longitude;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User sets the base API request https://api.citybik.es/v2/networks",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User sends the API request to get all bike info",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User validates the response status is 200",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://api.citybik.es/v2/networks",
      "offset": 31
    }
  ],
  "location": "APISteps.User_sets_the_base_API_request(String)"
});
formatter.result({
  "duration": 1031904600,
  "status": "passed"
});
formatter.match({
  "location": "APISteps.User_sends_the_API_request_to_get_all_bike_info()"
});
formatter.result({
  "duration": 4320826200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 38
    }
  ],
  "location": "APISteps.User_validates_response_status_code(int)"
});
formatter.result({
  "duration": 987400,
  "status": "passed"
});
});