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
  "error_message": "org.openqa.selenium.WebDriverException: unknown error: Element \u003ci class\u003d\"icon-cart\"\u003e\u003c/i\u003e is not clickable at point (1129, 8). Other element would receive the click: \u003cdiv class\u003d\"grid-header-row\"\u003e...\u003c/div\u003e\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.45.615291 (ec3682e3c9061c10f26ea9e5cdcf3c53f3f74387),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.6.0\u0027, revision: \u00276fbf3ec767\u0027, time: \u00272017-09-27T15:28:36.4Z\u0027\nSystem info: host: \u0027ADEOLA\u0027, ip: \u0027192.168.99.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_111\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, timeouts\u003d{implicit\u003d0, pageLoad\u003d300000, script\u003d30000}, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:59968}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, platformName\u003dXP, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003ddismiss, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.45.615291 (ec3682e3c9061c10f26ea9e5cdcf3c53f3f74387), userDataDir\u003dC:\\Users\\admin\\AppData\\Local\\Temp\\scoped_dir16012_1135}, takesHeapSnapshot\u003dtrue, unhandledPromptBehavior\u003ddismiss, pageLoadStrategy\u003dnormal, strictFileInteractability\u003dfalse, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d71.0.3578.98, browserConnectionEnabled\u003dfalse, proxy\u003dProxy(), nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: e39e961fd03ca051cfa938b7739dfb0b\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:82)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:45)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:164)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:586)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:279)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:83)\r\n\tat com.RSComponentsAutomation.framework.pageObjects.homePage.clickCartIcon(homePage.java:32)\r\n\tat com.RSComponentsAutomation.framework.stepsDefinitions.checkoutSteps.iNavigateToBasketSummary(checkoutSteps.java:87)\r\n\tat ✽.I navigate to basket summary(src/test/resources/features/Checkout.feature:22)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I verify basket information is as expected",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyBasketInformationIsAsExpected()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I proceed to checkout as guest",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iProceedToCheckoutAsGuest()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I add delivery information",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddDeliveryInformation()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I navigate to payment",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iNavigateToPayment()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I add \u0027Visa\u0027 payment details",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iAddPaymentDetails(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I navigate to order review",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iNavigateToOrderReview()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I verify that order review page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "checkoutSteps.iVerifyOrderReviewPageIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I verify that order information is correct",
  "keyword": "And "
});
formatter.match({
  "location": "checkoutSteps.iVerifyOrderInformation()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
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
