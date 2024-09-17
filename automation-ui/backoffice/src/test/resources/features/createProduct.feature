Feature: Create Product

  Scenario: Create Product successfully
    Given I logged in successfully
    When I click to product on menu
    Then I should be in product list page
    When I click to create product button
    Then I should be in create product page
    Given I fill necessary data for product and submit
    Then I should be in product list page