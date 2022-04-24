package org.complete.framework.pageobjects;

import org.complete.framework.utilities.Logs;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    protected SoftAssert softAssert;
    protected Logs log = new Logs();
    public static String mainUrl = "https://www.saucedemo.com";

    private void initWait(int timeOut) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        softAssert = new SoftAssert();
        initWait(5);
    }

    protected BasePage(WebDriver driver, int timeOut) {
        this(driver);
        initWait(timeOut);
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void typeText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean verifyIsDisplayed(By locator) {
        try {
            waitForVisibility(locator);
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    protected void waitPage(By locator, String pageName) {
        log.info("Waiting " + pageName + " to load");
        waitForVisibility(locator);
        log.info(pageName + " loaded successfully");
    }

    public void goToIndex() {
        log.info("Going to the main url");
        driver.get(mainUrl);
    }

    public abstract void waitPageToLoad();
    public abstract void verifyPage();
}
