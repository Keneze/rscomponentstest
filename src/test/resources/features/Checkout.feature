@Checkout
Feature: As a registered or guest user, I want to be able to complete order successfully

  @Checkout-Test1
  Scenario: As a registered customer I am able to create oder successfully
    Given I am on RS Components homepage as registered
    When I search for 'wires'
    And I add first product to basket from search results
    And I navigate to basket summary
    And I verify basket information is as expected
    And I navigate to checkout
    And I verify delivery information is pre-populated
    And I add my card cvv information
    Then I verify I can place order

  @Checkout-Test2
  Scenario: Create order as a guest customer
    Given I am on RS Components homepage as guest
    When I search for 'battery'
    And I change the quantity of first product to '2'
    And I add the product to basket from search results
    And I navigate to basket summary
    And I verify basket information is as expected
    And I proceed to checkout as guest
    And I add delivery information
    And I navigate to payment
    And I add 'Visa' payment details
    And I navigate to order review
    Then I verify that order review page is displayed
    And I verify that order information is correct


