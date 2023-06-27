Feature: Test Cucumber options

  @important
  Scenario: Test scenario
    Given print "Quarkus rocks!"

  @ignored
  Scenario: Ignored scenario
    Given print "should not run!"

  @important
  Scenario: Test scenario OK
    Given I call the endpoint
    Then the response is ok

  Scenario: Test scenario error
    Given I call a non-existing endpoint
    Then I get an error
