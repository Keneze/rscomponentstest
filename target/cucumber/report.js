$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Checkout.feature");
formatter.feature({
  "name": "As a registered or guest user, I want to be able to complete order successfully",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Checkout"
    }
  ]
});
formatter.scenario({
  "name": "As a registered customer I am able to create oder successfully",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Checkout"
    },
    {
      "name": "@Checkout-Test1"
    }
  ]
});
formatter.step({
  "name": "I am on RS Components homepage as registered",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027wires\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add first product to basket from search results",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddFirstProductToBagFromResultsList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to basket summary",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iNavigateToBasketSummary()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify basket information is as expected",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyBasketInformationIsAsExpected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to checkout",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToCheckout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify delivery information is pre-populated",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyDeliveryInformationIsPrepopulated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add my card cvv information",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddMyCardCVVInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify I can place order",
  "keyword": "Then "
});
formatter.match({
  "location": "checkoutSteps.iVerifyICanPlaceOrder()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Create order as a guest customer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Checkout"
    },
    {
      "name": "@Checkout-Test2"
    }
  ]
});
formatter.step({
  "name": "I am on RS Components homepage as guest",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027battery\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I change the quantity of first product to \u00272\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iChangeTheQuantity(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add the product to basket from search results",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddFirstProductToBagFromResultsList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to basket summary",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iNavigateToBasketSummary()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify basket information is as expected",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyBasketInformationIsAsExpected()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to checkout as guest",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToCheckoutAsGuest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add delivery information",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddDeliveryInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to payment",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iNavigateToPayment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add \u0027Visa\u0027 payment details",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddPaymentDetails(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to order review",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iNavigateToOrderReview()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify that order review page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "checkoutSteps.iVerifyOrderReviewPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify that order information is correct",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyOrderInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/resources/features/SearchResultsFilter.feature");
formatter.feature({
  "name": "As RS customer, I want to be able to apply filters to my search results",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Search-Filter"
    }
  ]
});
formatter.scenario({
  "name": "Check that user can apply single filter on search results page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Search-Filter"
    },
    {
      "name": "@Search-Filter-Test1"
    }
  ]
});
formatter.step({
  "name": "I am on RS Components homepage as guest",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027monitors\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \u0027Brand\u0027 filter named \u0027Samsung\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchResultsFilterSteps.iApplyABrandFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify filter is present in filters breadcrumbs correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "searchResultsFilterSteps.iVerifyFilterIsPresentInFilterCrumbsCorrectly()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify displayed results are correct",
  "keyword": "And "
});
formatter.match({
  "location": "searchResultsFilterSteps.iVerifyDisplayedResutsAreCorrect()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the total search results for the applied filter",
  "keyword": "And "
});
formatter.match({
  "location": "searchResultsFilterSteps.iVerifyTotalSearchResults()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Check that user can apply more than one filter on search results page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Search-Filter"
    },
    {
      "name": "@Search-Filter-Test2"
    }
  ]
});
formatter.step({
  "name": "I am on RS Components homepage as guest",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027sealants\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \u0027Brand\u0027 filter named \u0027Geocel\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchResultsFilterSteps.iApplyABrandFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select another \u0027Colour\u0027 filter named \u0027White\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchResultsFilterSteps.iApplyABrandFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify multiple filters has been applied applied correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "searchResultsFilterSteps.iVerifyMultipleFiltersHasBeenAppliedCorrectly()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the total search results for the applied filter",
  "keyword": "And "
});
formatter.match({
  "location": "searchResultsFilterSteps.iVerifyTotalSearchResults()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Check that user can remove filters",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Search-Filter"
    },
    {
      "name": "@Search-Filter-Test3"
    }
  ]
});
formatter.step({
  "name": "I am on RS Components homepage as guest",
  "keyword": "Given "
});
formatter.match({
  "location": "checkoutSteps.RSComponentsHomepageIsDisplayed(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \u0027clock\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iSearchForItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select \u0027Display\u0027 filter named \u0027Analogue\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchResultsFilterSteps.iApplyABrandFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I select another \u0027Battery Type\u0027 filter named \u0027AA\u0027",
  "keyword": "And "
});
formatter.match({
  "location": "searchResultsFilterSteps.iApplyABrandFilter(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I remove all filters",
  "keyword": "When "
});
formatter.match({
  "location": "searchResultsFilterSteps.iRemoveAllFilters()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify all filters has been removed",
  "keyword": "Then "
});
formatter.match({
  "location": "searchResultsFilterSteps.iVerifyAllFiltersHasBeenRemoved()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});