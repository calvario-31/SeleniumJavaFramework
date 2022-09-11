package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.Logs;
import webElements.list.$$;
import webElements.single.$;

public abstract class BasePage {
    private final WebDriver driver;
    private final String mainUrl = "https://www.saucedemo.com";
    private int timeOut = 5;
    protected final SoftAssert softAssert;
    protected final Logs log = new Logs();

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        softAssert = new SoftAssert();
    }

    protected BasePage(WebDriver driver, int timeOut) {
        this(driver);
        this.timeOut = timeOut;
    }

    protected void waitPage($ webElement, String pageName) {
        log.info("Waiting " + pageName + " to load");
        webElement.waitForVisibility(timeOut);
        log.info(pageName + " loaded successfully");
    }

    protected $ $(By locator) {
        return new $(locator, driver);
    }

    protected $$ $$(By locator) {
        return new $$(locator, driver);
    }

    public void goToIndex() {
        log.info("Going to the main url");
        driver.get(mainUrl);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}
