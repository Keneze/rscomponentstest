package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.helpers.globalHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.List;

public class basketPage extends globalHelper {

    private By clearBasketBtn = By.cssSelector("#clearBasketButton > span");
    private By confirmClearBasketBtn2 = By.xpath("//*[@id=\"confirmDeleteContinue\"]//span");
    private By listOfItemsPrices = By.cssSelector("#shoppingBasketForm\\3a WebBasketLineWidgetActionVALIDATION_ERROR_EVENT > table > tbody > tr > td.unitTd > div:nth-child(1)");
    private By listOfItemsStockNo = By.cssSelector("#shoppingBasketForm\\3a WebBasketLineWidgetActionVALIDATION_ERROR_EVENT > table > tbody > tr > td.descriptionTd > div > span.textTitle");
    private By listOfItemsQty = By.cssSelector("#shoppingBasketForm\\3a WebBasketLineWidgetActionVALIDATION_ERROR_EVENT > table > tbody > tr > td.quantityTd > input");
    private By checkoutBtn = By.id("checkoutSecurelyAndPuchBtn");
    private By returnToHome = By.cssSelector("#pageHeader > div.shHeader > a > i");
    private By grandTotal = By.cssSelector("#shoppingBasketForm\\3a OrderTotalDetailWidgetActionCARTTotalsDIVId > table > tbody > tr > td.orderValueCell.grandTotalCell");
    private By itemTotalPrice = By.cssSelector("#shoppingBasketForm\\3a WebBasketLineWidgetActionVALIDATION_ERROR_EVENT > table > tbody > tr > td.costTd.last > div");
    private By goodsTotal = By.cssSelector("#shoppingBasketForm\\3a OrderTotalDetailWidgetActionCARTTotalsDIVId > table > tbody > tr:nth-child(1) > td.orderValueCell");
    private By orderTax = By.cssSelector("#shoppingBasketForm\\3a OrderTotalDetailWidgetActionCARTTotalsDIVId > table > tbody > tr:nth-child(3) > td.orderValueCell.tax");
    private By shippingPrice = By.cssSelector("#shoppingBasketForm\\3a OrderTotalDetailWidgetActionCARTTotalsDIVId > table > tbody > tr:nth-child(2) > td.orderValueCell.freeDelivery");
    private static final By guestEmail = By.id("guestCheckoutForm:GuestWidgetAction_emailAddress_decorate:GuestWidgetAction_emailAddress");
    private By guestCheckoutBtn = By.cssSelector("#guestCheckoutForm\\3a guestCheckout");
    private By acceptCookie = By.id("js-cookie-accept");

    public void acceptCookies(){ waitForElementVisibleBy(acceptCookie).click(); }

    public boolean acceptCookiesPresent(){ return  isElementPresent(acceptCookie); }

    public void clickClearBasketBtn() {
        sleep(1); //adding little break here to avoid test breakage
        waitForExpectedElement(clearBasketBtn).click();
    }

    public void clickConfirmClearBasketBox() {
        clickElementUsingJavascriptExecutor(waitForExpectedElement(confirmClearBasketBtn2));
    }

    public String getItemPriceInCart(String itemsNoInCart) {
        return visibilityOfAllElementsLocatedBy(listOfItemsPrices).get(Integer.parseInt(itemsNoInCart) - 1).getText().trim();
    }

    public String getItemStockNoInCart(String itemNo) {
        return visibilityOfAllElementsLocatedBy(listOfItemsStockNo).get(Integer.parseInt(itemNo) - 1).getText().trim();
    }

    public String getItemQtyInCart(String itemNo) {
        return visibilityOfAllElementsLocatedBy(listOfItemsQty).get(Integer.parseInt(itemNo) - 1).getAttribute("value").trim();
    }

    public List<WebElement> getItemTotalPrice() {
        return visibilityOfAllElementsLocatedBy(itemTotalPrice);
    }

    public List<WebElement> getItemEachPrice() {
        return visibilityOfAllElementsLocatedBy(listOfItemsPrices);
    }

    public List<WebElement> getItemQuantity() {
        return visibilityOfAllElementsLocatedBy(listOfItemsQty);
    }

    public void clickCheckoutBtn() {
        waitForElementVisibleBy(checkoutBtn).click();
    }

    public void clickReturnToHome() {
        waitForElementVisibleBy(returnToHome).click();
    }

    public String getGrandTotal() {
        return waitForElementVisibleBy(grandTotal).getText().trim();
    }

    public boolean checkAllItemTotal() {
        boolean itemTotalIsCorrect = false;
        for (int i = 0; i < getItemTotalPrice().size(); i++) {
            double itemEachPrice = getDoubleValueOfDollar(getItemEachPrice().get(i).getText().trim());
            double itemQuantity = getDoubleValueOfDollar(getItemQuantity().get(i).getAttribute("value").trim());
            double itemTotalPrice = getDoubleValueOfDollar(getItemTotalPrice().get(i).getText().trim());
            double expectedItemTotal = itemEachPrice * itemQuantity;
            if (expectedItemTotal != itemTotalPrice) {
                itemTotalIsCorrect = false;
                break;
            } else if (expectedItemTotal == itemTotalPrice) {
                itemTotalIsCorrect = true;
            }
        }
        return itemTotalIsCorrect;
    }

    public boolean checkGoodsTotal() {
        boolean value = false;
        double total = 0;
        for (int i = 0; i < getItemTotalPrice().size(); i++) {
            String itemTotal = getItemTotalPrice().get(i).getText().trim();
            double ConvertedItemTotal = getDoubleValueOfDollar(itemTotal);
            if (total >= 0) {
                total = total + ConvertedItemTotal;
            }
        }
        double expectedTotal = getDoubleValueOfDollar(waitForExpectedElement(goodsTotal).getText().trim());
        if (total == expectedTotal) {
            value = true;
        }
        return value;
    }

    public double getShippingPrice(){
        double value;
        String shippingPriceValue = waitForElementVisibleBy(shippingPrice).getText().trim();
        if(shippingPriceValue.equalsIgnoreCase("Free")){
            value = 0.00;
        }else{
            value = getDoubleValueOfDollar(shippingPriceValue);
        }
        return value;
    }

    public boolean checkGrandTotalIsCorrect(){
        boolean value = false;
        double orderGoodsTotal = getDoubleValueOfDollar(waitForElementVisibleBy(goodsTotal).getText().trim());
        double shippingPrice = getShippingPrice();
        double VAT = getDoubleValueOfDollar(waitForElementVisibleBy(orderTax).getText().trim());
        double orderGrandTotal = getDoubleValueOfDollar(getGrandTotal());
        Double expectedOrderGrandTotal = orderGoodsTotal+shippingPrice+VAT;
        DecimalFormat formatter = new DecimalFormat("#.00");
        expectedOrderGrandTotal = Double.valueOf(formatter.format(expectedOrderGrandTotal));
        if(orderGrandTotal == expectedOrderGrandTotal){
            value = true;
        }
        return value;
    }

    public void enterGuestCheckoutEmail(String email){
        sleep(1); // adding little wait here to avoid test breakage
        enterText(guestEmail, email);
    }

    public void clickGuestCheckoutBtn(){
        clickElementUsingJavascriptExecutor(waitForElementVisibleBy(guestCheckoutBtn));
    }
}
