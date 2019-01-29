package com.rscomponents.automationframework.pageObjects;

import com.rscomponents.automationframework.helpers.globalHelper;
import org.openqa.selenium.By;

public class homePage extends globalHelper {

    private By RSComponentsLogo = By.cssSelector("#pageHeader > div.shHeader > a > i");
    private By loginLogout = By.cssSelector("#pageHeader > div.shHeader > div.loginContainer > div > a:nth-child(1)");
    private By cartIcon = By.xpath("//*[@id='pageHeader']/div/div[3]/a/i");
    private By cartIconItemCount = By.cssSelector("#js-basketQty");
    private By searchBox = By.cssSelector("#searchTerm");
    private By searchBoxBtn = By.cssSelector("#btnSearch");
    private By acceptCookiesSettings = By.cssSelector("#js-cookie-accept");

    public boolean isHomepageLogoPresent(){
        return waitForElementVisibleBy(RSComponentsLogo).isDisplayed();
    }

    public void clickAcceptCookiesBtn(){
        if(driver.findElement(acceptCookiesSettings).isDisplayed()) {
            waitForElementVisibleBy(acceptCookiesSettings).click();
        }
    }

    public void clickLoginLogout(){
        waitForElementVisibleBy(loginLogout).click();
    }

    public void clickCartIcon(){
        sleep(2); // adding this wait to stop test breakage
        waitForElementVisibleBy(cartIcon).click();
    }

    public boolean isCartEmpty(){
        return waitForElementVisibleBy(cartIconItemCount).getText().trim().equalsIgnoreCase("0");
    }
    public void makeASearch(String searchTerm){
        waitForElementVisibleBy(searchBox).sendKeys(searchTerm);
        waitForElementVisibleBy(searchBoxBtn).click();
    }
    public void startAsGuest(){
       String loginStatus = waitForElementVisibleBy(loginLogout).getAttribute("title").trim();
       if(loginStatus.equalsIgnoreCase("Log Out")){
           clickLoginLogout();
       }
    }
}
