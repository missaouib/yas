Feature: User Login and Add To Cart Flow

  Scenario: Successful login with valid credentials and add to basket
    Given I login successful
    When I click on category item
    Then I should be redirected to the product list
    When I click on product item
    Then I should be redirected to the product item detail
    When I click on button add to cart
    When I click on basket
    Then This item is existed on table