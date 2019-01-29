package com.RSComponentsAutomation.framework.frameworkHelpers;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.RSComponentsAutomation.framework.frameworkHelpers.webdriverHelper.buildChromeBrowser;
import static com.RSComponentsAutomation.framework.frameworkHelpers.webdriverHelper.buildFireFoxBrowser;
import static com.RSComponentsAutomation.framework.frameworkHelpers.webdriverHelper.buildIEBrowser;

public class globalHelper {

    @Getter
    protected WebDriver driver;
    @Getter
    protected WebDriverWait wait;
    Properties prop = new Properties();

    private By declineSurvey = By.cssSelector("#fsrInvite > section.fsrInvite__buttons.fsrInvite--margin > button.fsrButton.fsrButton__inviteDecline.fsrDeclineButton");
    private String browser;

    {
        try {
            browser = getValueFromPropsFile("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeSurveyPopupIfPresent(){
        try {
            WebDriverWait wait = new WebDriverWait(driver,1);
            wait.until(ExpectedConditions.visibilityOfElementLocated(declineSurvey));
            driver.findElement(declineSurvey).click();
        } catch (Throwable e) {

        }
    }

     protected globalHelper() {
        this.driver = webdriverHelper.getWebDriver();
        this.wait = new WebDriverWait(driver, 30);
    }

    protected WebElement waitForExpectedElement(final By by){
        closeSurveyPopupIfPresent();
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> visibilityOfAllElementsLocatedBy(final By by){
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void startHomepage() throws Throwable {
        if (driver == null) {
                if(browser.equalsIgnoreCase("chrome")) {
                    driver = buildChromeBrowser();
                }else if(browser.equalsIgnoreCase("firefox")){
                    driver = buildFireFoxBrowser();
                }else if(browser.equalsIgnoreCase("ie")){
                    driver = buildIEBrowser();
                }
            }
            driver.navigate().to(getValueFromPropsFile("homepage"));
    }

    public void clickElementUsingJavascriptExecutor(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public void selectByText(WebElement element, String text){
        waitForElementVisibility(element).click();
        Select selectFromDropdown = new Select(element);
        selectFromDropdown.selectByVisibleText(text);
    }

    public Double getDoubleValueOfDollar(String value){
        String Value = value.replaceAll("\\£|(?<=\\d),(?=\\d)", "");
        double newValue = Double.parseDouble(Value);
        DecimalFormat formatter = new DecimalFormat("#.00");
        return Double.valueOf(formatter.format(newValue));
    }

    public String getValueFromPropsFile(String key) throws IOException {
        prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\general.properties"));
        return prop.getProperty(key);
    }

    protected void waitClearAndEnterText(final By by, String text) {
        closeSurveyPopupIfPresent();
        waitForElementVisibility(waitForExpectedElement(by)).clear();
        waitForExpectedElement(by).sendKeys(text);
    }

    public WebElement waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementPresent(By locator){
        boolean isPresent = false;
        List<WebElement> elements = driver.findElements(locator);
        if(elements.size() != 0){
            isPresent = true;
        }
        return isPresent;
    }

    public void keepEyeOnSurveyPopup(){
        if(isElementPresent(declineSurvey)){
            closeSurveyPopupIfPresent();
        }
    }

    public WebElement waitForElementVisibleBy(By by) {
        closeSurveyPopupIfPresent();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void enterText(By by, String text){
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
