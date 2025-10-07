Feature: Info endpoint
  Scenario: GET /status/info returns name, version, and description
    When the client calls /info
    Then the client receives status code 200
    And the response JSON has key "name"
    And the response JSON has key "version"
    And the response JSON has key "description"