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
