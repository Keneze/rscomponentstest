package com.rscomponents.automationframework.pageObjects;

import com.rscomponents.automationframework.helpers.globalHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class deliveryDetailsPage extends globalHelper {

    private By savedAddress = By.cssSelector("#listAddressListId > div.manageListItem.manageListItemSelected > table > tbody > tr > td.listAddressItemdataTd > div");
    private By addAddressBtn = By.cssSelector("#deliveryCollectionForm\\3a j_idt1360");
    private By companyName = By.id("deliveryCollectionForm:AddDeliveryAddressWidgetAction_companyNameOne_decorate:AddDeliveryAddressWidgetAction_companyNameOne");
    private By proceedToPayment = By.cssSelector("#checkoutSecurelyBtn");
    private By guestTitle = By.xpath("//*[@id='deliveryCollectionForm:CustomerContactDetailsWidgetAction_title_decorate']/span/select");
    private By guestFirstName = By.cssSelector("#deliveryCollectionForm\\3a CustomerContactDetailsWidgetAction_firstName_decorate\\3a CustomerContactDetailsWidgetAction_firstName");
    private By guestSurname = By.cssSelector("#deliveryCollectionForm\\3a CustomerContactDetailsWidgetAction_surName_decorate\\3a CustomerContactDetailsWidgetAction_surName");
    private By guestPhone = By.cssSelector("#deliveryCollectionForm\\3a CustomerContactDetailsWidgetAction_contactNumber_decorate\\3a CustomerContactDetailsWidgetAction_contactNumber");
    private By guestFullName = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_companyNameOne_decorate\\3a GuestDeliveryAddressWidgetAction_companyNameOne");
    private By guestAddressLine1 = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_addressLineOne_decorate\\3a GuestDeliveryAddressWidgetAction_addressLineOne");
    private By guestAddressLine2 = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_addressLineTwo_decorate\\3a GuestDeliveryAddressWidgetAction_addressLineTwo");
    private By guestTown = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_addressLineThree_decorate\\3a GuestDeliveryAddressWidgetAction_addressLineThree");
    private By guestCounty = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_selectedRegion_decorate\\3a selectedRegion");
    private By guestPostcode = By.cssSelector("#deliveryCollectionForm\\3a GuestDeliveryAddressWidgetAction_postCode_decorate\\3a GuestDeliveryAddressWidgetAction_postCode");

    public WebElement savedAddressElement(){
        return waitForExpectedElement(savedAddress);
    }

    public void clickAddAddressBtn(){
        clickElementUsingJavascriptExecutor(waitForExpectedElement(addAddressBtn));
    }

    public void enterAddressInformation(){
        waitForExpectedElement(companyName).sendKeys("selfemployed");
    }

    public void clickProceedToPayment(){
        waitForExpectedElement(proceedToPayment).click();
    }

    public void enterDeliveryAddressAsGuest() throws IOException {
        selectByText(waitForExpectedElement(guestTitle), getValueFromPropsFile("title"));
        waitForElementVisibleBy(guestFirstName).sendKeys(getValueFromPropsFile("firstname"));
        waitForElementVisibleBy(guestSurname).sendKeys(getValueFromPropsFile("lastname"));
        waitForElementVisibleBy(guestPhone).sendKeys(getValueFromPropsFile("phone"));
        waitForElementVisibleBy(guestFullName).sendKeys(getValueFromPropsFile("fullname"));
        waitForElementVisibleBy(guestAddressLine1).sendKeys(getValueFromPropsFile("address1"));
        waitForElementVisibleBy(guestAddressLine2).sendKeys(getValueFromPropsFile("address2"));
        waitForElementVisibleBy(guestTown).sendKeys(getValueFromPropsFile("town"));
        selectByText(waitForElementVisibleBy(guestCounty), getValueFromPropsFile("county"));
        waitForElementVisibleBy(guestPostcode).sendKeys(getValueFromPropsFile("postcode"));
    }
}
