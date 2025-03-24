Feature: Shopping cart icon basic functionality
  Shopping cart icon should show the number of items in the cart

  Scenario: Add a product to the cart
    Given the browser is open
    When I open the main page
    And I navigate to the device list
    And I navigate to the smartphone without subscription list
    And I click on the second smartphone in the list
    And I click the add to cart button
    Then the cart icon shows "1" item after returning to the main page