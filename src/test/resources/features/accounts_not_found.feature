Feature: Accounts endpoint
  Scenario: GET /account/{id} for non-existent id returns 404
    When the client calls /account/999999
    Then the client receives status code 404