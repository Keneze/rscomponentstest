package com.rscomponents.automationframework.stepsDefinitions;

import com.rscomponents.automationframework.dataFactory.checkoutData;
import com.rscomponents.automationframework.pageObjects.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

public class checkoutSteps {

    private homePage HomePage;
    private signinPage signinPage;
    private basketPage BasketPage;
    private searchPage SearchPage;
    private checkoutData OrderModel;
    private deliveryDetailsPage DeliveryDetailsPage;
    private paymentPage PaymentPage;
    private orderReviewPage OrderReviewPage;

    public checkoutSteps(homePage homePage, signinPage signinPage, basketPage basketPage, searchPage searchPage, checkoutData orderModel,
                         deliveryDetailsPage deliveryDetailsPage, paymentPage paymentPage, orderReviewPage orderReviewPage){
        this.HomePage = homePage;
        this.signinPage = signinPage;
        this.BasketPage = basketPage;
        this.SearchPage = searchPage;
        this.OrderModel = orderModel;
        this.DeliveryDetailsPage = deliveryDetailsPage;
        this.PaymentPage = paymentPage;
        this.OrderReviewPage = orderReviewPage;
    }

    @Given("^I am on RS Components homepage as (.*)$")
    public void RSComponentsHomepageIsDisplayed(String usertype) throws Throwable {
        HomePage.startHomepage();
        assertTrue(HomePage.isHomepageLogoPresent());
        if(BasketPage.acceptCookiesPresent()){
            BasketPage.acceptCookies();
        }
        if(usertype.equals("registered")){
            HomePage.clickLoginLogout();
            signinPage.loginAsCustomer();
        } else {
            HomePage.startAsGuest();
        }
        if(!HomePage.isCartEmpty()){
            HomePage.clickCartIcon();
            BasketPage.clickClearBasketBtn();
            BasketPage.clickConfirmClearBasketBox();
            BasketPage.sleep(3);
            BasketPage.clickReturnToHome();
        }
    }

    @When("^I search for '(.*)'$")
    public void iSearchForItem(String searchTerm){
        HomePage.makeASearch(searchTerm);
    }

    @And("^I change the quantity of first product to '(.*)'$")
    public void iChangeTheQuantity(String Qty){
        SearchPage.changeFirstItemQuantity(Qty);
        OrderModel.setQuantity(Qty);
    }

    @And("^I add (?:first product|the product) to basket from search results$")
    public void iAddFirstProductToBagFromResultsList(){
        SearchPage.addFirstItemToCartFromSearchResults();
        String itemPrice = SearchPage.getFirstItemPriceFromSearchResults();
        String itemStockNo = SearchPage.getFirstItemStockNoFromSearchResults();
        OrderModel.setProductPrice(itemPrice);
        OrderModel.setProductStockNo(itemStockNo);
    }

    @And("^I navigate to basket summary$")
    public void iNavigateToBasketSummary(){
        HomePage.clickCartIcon();
    }

    @And("^I verify basket information is as expected$")
    public void iVerifyBasketInformationIsAsExpected(){
        assertTrue(BasketPage.checkGrandTotalIsCorrect());
        assertEquals(OrderModel.getProductStockNo(), BasketPage.getItemStockNoInCart("1"));
        assertTrue(BasketPage.checkGoodsTotal());
        assertEquals(OrderModel.getProductPrice(), BasketPage.getItemPriceInCart("1"));
        assertEquals(OrderModel.getQuantity(), BasketPage.getItemQtyInCart("1"));
        assertTrue(BasketPage.checkAllItemTotal());
        assertTrue(BasketPage.checkAllItemTotal());
        OrderModel.setBasketGrandTotal(BasketPage.getGrandTotal());
    }

    @And("^I navigate to checkout$")
    public void iProceedToCheckout() { BasketPage.clickCheckoutBtn(); }

    @And("^I verify delivery information is pre-populated$")
    public void iVerifyDeliveryInformationIsPrepopulated(){
        assertTrue(OrderReviewPage.isDeliveryInfoPopulated());
    }

    @And("^I add my card cvv information$")
    public void iAddMyCardCVVInformation() throws IOException {
        OrderReviewPage.enterCvv(OrderReviewPage.getValueFromPropsFile("cvv"));
    }

    @Then("^I verify I can place order$")
    public void iVerifyICanPlaceOrder(){
        assertTrue(OrderReviewPage.isPlaceOrderBtnDisplayed());
        OrderReviewPage.clickBackToHome();
        HomePage.clickLoginLogout();
    }

    @And("^I proceed to checkout as guest$")
    public void iProceedToCheckoutAsGuest() throws IOException, InterruptedException {
        BasketPage.clickCheckoutBtn();
        BasketPage.enterGuestCheckoutEmail(BasketPage.getValueFromPropsFile("email.guest"));
        BasketPage.clickGuestCheckoutBtn();
        BasketPage.sleep(3);
    }

    @And("^I verify saved address is present on page$")
    public void iVerifySavedAddressIsPresent(){
        assertTrue(DeliveryDetailsPage.savedAddressElement().isDisplayed());
    }

    @And("^I add a new delivery address$")
    public void iAddANewDeliveryAddress(){
        DeliveryDetailsPage.clickAddAddressBtn();
        DeliveryDetailsPage.enterAddressInformation();
    }
    @And("^I navigate to payment$")
    public void iNavigateToPayment(){
        DeliveryDetailsPage.clickProceedToPayment();
    }

    @And("^I navigate to order review$")
    public void iNavigateToOrderReview(){
        PaymentPage.clickOrderPreviewBtn();
    }

    @Then("^I verify that order review page is displayed$")
    public void iVerifyOrderReviewPageIsDisplayed(){
       assertTrue(OrderReviewPage.getOrderReviewTitle().isDisplayed());
       assertTrue(OrderReviewPage.isPlaceOrderBtnDisplayed());
    }

    @And("^I verify that order information is correct$")
    public void iVerifyOrderInformation(){
        assertEquals(OrderModel.getBasketGrandTotal(), OrderReviewPage.getGrandTotal());
    }

    @And("^I add delivery information$")
    public void iAddDeliveryInformation() throws IOException {
        DeliveryDetailsPage.enterDeliveryAddressAsGuest();
    }

    @And("^I add '(.*)' payment details$")
    public void iAddPaymentDetails(String paymentType) throws IOException {
        if(paymentType.equals("Visa")){
            PaymentPage.enterCardDetails("visa");
        } else if(paymentType.equals("MasterCard")){
            PaymentPage.enterCardDetails("mastercard");
        } else if(paymentType.equals("American Express")){
            PaymentPage.enterAmericanExpressCardDetails();
        }
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) HomePage.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }

}