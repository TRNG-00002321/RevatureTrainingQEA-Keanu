@cart
Feature: Shopping Cart Management
  As an online shopper
  I want to manage items in my shopping cart
  So that I can purchase the products I need

  Background:
    Given the user is logged in
    And the product catalog is available

  @smoke
  Scenario: Add single item to cart
    # Given: User is on a product page
  Given user is on a product page
    # When: User clicks add to cart
  When user clicks add to cart
    # Then: Item appears in cart, cart count updates
  Then item appears in cart, cart count updates

  Scenario: Add multiple quantities of an item
    # Consider quantity selector interaction
  Given user is on a product page
  When user selects multiple items
  Then items appear in cart, cart count updates

  Scenario: View cart contents
    # Include verification of item details shown
  Given user is on product page
  When  user selects cart icon
  Then items in cart appear on screen

  Scenario: Update item quantity in cart
    # Include before/after quantity and price verification
  Given user is on product page
  When user increases item quantity
  Then item quantity increases
  And price is updated

  Scenario: Remove item from cart
    # Verify item no longer appears and price updates
  Given user is on product page
  When user removes item from cart
  Then item is removed from cart
  And price is updated

  Scenario: Empty cart displays message
    # Verify appropriate message when cart is empty
  Given user is on product page
  When cart is empty
  Then cart displays message that cart is empty


  Scenario: Cart total calculates correctly
    Given the user has the following items in cart:
      | Product     | Price  | Quantity |
      | Widget A    | 10.00  | 2        |
      | Widget B    | 25.00  | 1        |
    Then the cart subtotal should be "$45.00"