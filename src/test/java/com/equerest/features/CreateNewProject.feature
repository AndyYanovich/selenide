Feature:
  As a enterpreneur
  I want to register a business project

  Scenario: Register a new project
    Given I am on new project registration page
    When I fill my first name "Vasyl" and last name "Petrenko"
    And I fill my City "Kyiv"
