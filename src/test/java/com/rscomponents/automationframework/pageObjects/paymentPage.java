package com.rscomponents.automationframework.pageObjects;

import com.rscomponents.automationframework.helpers.globalHelper;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class paymentPage extends globalHelper {

    private By orderPreviewBtn = By.id("checkoutSecurelyBtn");
    private By guestPaymentTypeRadioBtn = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_paymentFormDiv_Fields > table > tbody > tr > td > div.leftDiv > table > tbody > tr > td > input[type=\"radio\"]");
    private By guestCcardBox1 = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardNumber_decorate > span > input:nth-child(6)");
    private By guestCcardBox2 = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardNumber_decorate > span > input:nth-child(7)");
    private By guestCcardBox3 = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardNumber_decorate > span > input:nth-child(8)");
    private By guestCcardBox4 = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardNumber_decorate > span > input:nth-child(9)");
    private By paymentTypeRadioBtn = By.cssSelector("#paymentForm\\3a LoggedInUserSelectPaymentWidgetActionPAMLId > div > div.manageList > div > table > tbody > tr > td.radioTd > input");
    private By paymentTypes = By.cssSelector("#paymentForm\\3a LoggedInUserSelectPaymentWidgetActionPAMLId > div > div.manageList > div > table > tbody > tr > td> div > div > div.paymentText > span.paymentType.text");
    private By guestPaymentTypes = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_paymentFormDiv_Fields > table > tbody > tr > td > div.leftDiv > table > tbody > tr > td > div > a");
    private By guestCreditCardName = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_cardHolder_decorate\\3a AddGuestEmbeddedPaymentWidgetAction_cardHolder");
    private By guestCreditCardExpDate = By.cssSelector("#paymentForm\\3a AddGuestEmbeddedPaymentWidgetAction_expiryDate_decorate\\3a AddGuestEmbeddedPaymentWidgetAction_expiryDate");
    private By guestCreditCardCVV = By.id("paymentForm:AddGuestEmbeddedPaymentWidgetAction_securityCode_decorate:AddGuestEmbeddedPaymentWidgetAction_securityCode");
    private By guestCreditCardFullName = By.id("paymentForm:AddGuestEmbeddedPaymentWidgetAction_cardName_decorate:AddGuestEmbeddedPaymentWidgetAction_cardName");

    public void clickOrderPreviewBtn(){
        waitForElementVisibleBy(orderPreviewBtn).click();
        sleep(3);
    }

    private void formHelperUsingPropFile(By by, String key) throws IOException {
        waitForExpectedElement(by).sendKeys(getValueFromPropsFile(key));
    }

    private void formHelper(By by, String data){
        waitForExpectedElement(by).sendKeys(data);
    }

    public void enterCardDetails(String cardtype) throws IOException {
        List<String> cardDetails;
        if(cardtype.equals("visa")){
            cardDetails = Arrays.asList(getValueFromPropsFile("visacard").split(","));
        } else {
            cardDetails = Arrays.asList(getValueFromPropsFile("mastercard").split(","));
        }
        formHelper(guestCcardBox1, cardDetails.get(0));
        formHelper(guestCcardBox2, cardDetails.get(1));
        formHelper(guestCcardBox3, cardDetails.get(2));
        formHelper(guestCcardBox4, cardDetails.get(3));
        enterOtherCardInformation();
    }

    public void enterAmericanExpressCardDetails() throws IOException {
        List<String> cardDetails = Arrays.asList(getValueFromPropsFile("americanexpress").split(","));
        formHelper(guestCcardBox1,cardDetails.get(0) );
        formHelper(guestCcardBox2, cardDetails.get(1));
        formHelper(guestCcardBox3, cardDetails.get(2));
        enterOtherCardInformation();
    }

    public void enterOtherCardInformation() throws IOException {
        formHelperUsingPropFile(guestCreditCardName, "fullname");
        formHelperUsingPropFile(guestCreditCardExpDate, "expdate");
        formHelperUsingPropFile(guestCreditCardCVV, "cvv");
        formHelperUsingPropFile(guestCreditCardFullName, "fullname");
    }

}
