package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.Logs;
import webelements.list.$$;
import webelements.single.$;

public abstract class BasePage {
    public static final int DEFAULT_TIME_OUT = 5;
    private final WebDriver driver;
    private final String mainUrl = "https://www.saucedemo.com";
    protected final SoftAssert softAssert;
    private int timeOut;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        softAssert = new SoftAssert();
        timeOut = DEFAULT_TIME_OUT;
    }

    protected BasePage(WebDriver driver, int timeOut) {
        this(driver);
        this.timeOut = timeOut;
    }

    protected void waitPage($ webElement, String pageName) {
        Logs.info("Waiting " + pageName + " to load");
        webElement.waitForVisibility(timeOut);
        Logs.info(pageName + " loaded successfully");
    }

    protected $ $(By locator) {
        return new $(locator, driver, DEFAULT_TIME_OUT);
    }

    protected $$ $$(By locator) {
        return new $$(locator, driver);
    }

    public void goToIndex() {
        Logs.info("Going to the main url");
        driver.get(mainUrl);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}
