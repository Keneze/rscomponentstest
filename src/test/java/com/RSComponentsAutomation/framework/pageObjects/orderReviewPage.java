package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.frameworkHelpers.globalHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class orderReviewPage extends globalHelper {

    private By orderReviewTitle = By.cssSelector("#orderReviewForm > div.orderReviewLayoutContainer > div.deliveryHeaderDiv > span");
    private By placeOrderBtn = By.cssSelector("#checkoutSecurelyBtn");
    private By grandTotal = By.cssSelector("#orderReviewForm\\3a CheckoutNotificationSettingsWidgetAction_faoContactDetailsDisplayDiv > table > tbody > tr > td > div > div > div > span");
    private By deliveryDetailsInfo = By.cssSelector("#expressCheckoutOrderReviewForm\\3a customerContactDiv > div > div > div");
    private By cvv = By.xpath("//*[@id='expressCheckoutOrderReviewForm:j_idt526:LoggedInUserSelectPaymentWidgetAction_tempCvvNum_31333504']");
    private By home= By.cssSelector("#wrapper > div.headerDiv > div.logoDiv > a.headerLogo > img");


    private List<WebElement> getDeliveryInfoList(){ return visibilityOfAllElementsLocatedBy(deliveryDetailsInfo); }

    private List<WebElement> getPlaceOrderList(){ return  visibilityOfAllElementsLocatedBy(placeOrderBtn); }

    public void clickBackToHome(){ waitForExpectedElement(home).click();  }

    public boolean isDeliveryInfoPopulated() {
        boolean value = false;
        for(WebElement element : getDeliveryInfoList()){
            value = element.getText()!= "";
        }
        return value;
    }

    public void enterCvv(String value){ waitForExpectedElement(cvv).sendKeys(value); }

    public WebElement getOrderReviewTitle(){
        return waitForElementVisibleBy(orderReviewTitle);
    }

    public boolean isPlaceOrderBtnDisplayed(){
        boolean value = false;
        for(WebElement element : getPlaceOrderList()){
            value = element.isDisplayed();
        }
        return value;
    }

    public String getGrandTotal(){
        return waitForElementVisibleBy(grandTotal).getText().trim();
    }
}
