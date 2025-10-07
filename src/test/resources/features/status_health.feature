Feature: Health endpoint
  Scenario: GET /health returns ok
    When the client calls /health
    Then the client receives status code 200
    And the response JSON field "status" equals "ok"