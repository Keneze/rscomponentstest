package com.RSComponentsAutomation.framework.pageObjects;

import com.RSComponentsAutomation.framework.frameworkHelpers.globalHelper;
import org.openqa.selenium.By;
import java.io.IOException;

public class signinPage extends globalHelper {

    private By usernameField = By.name("username");
    private By passwordField = By.name("j_password");
    private By loginBtn = By.name("loginBtn");

    public void loginAsCustomer() throws IOException {
        String username = getValueFromPropsFile("username");
        String password = getValueFromPropsFile("password");
        waitForElementVisibleBy(usernameField).sendKeys(username);
        waitForElementVisibleBy(passwordField).sendKeys(password);
        clickLoginBtn();
    }

    private void clickLoginBtn(){
        waitForExpectedElement(loginBtn).click();
    }

}
