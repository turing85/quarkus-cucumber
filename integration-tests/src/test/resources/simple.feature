Feature: Test feature

  Scenario: Test scenario OK
    Given I call the endpoint
    Then the response is ok

  Scenario: Test scenario error
    Given I call a non-existing endpoint
    Then I get an error