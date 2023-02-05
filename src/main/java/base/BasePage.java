package base;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utilities.Logs;
import webelements.list.$$;
import webelements.single.$;

public abstract class BasePage {
    public static final int DEFAULT_TIME_OUT = 5;
    private final String mainUrl = "https://www.saucedemo.com";
    protected final SoftAssert softAssert;
    private int timeOut;

    protected BasePage() {
        softAssert = new SoftAssert();
        timeOut = DEFAULT_TIME_OUT;
    }

    protected BasePage(int timeOut) {
        this();
        this.timeOut = timeOut;
    }

    protected void waitPage($ webElement, String pageName) {
        Logs.info("Waiting %s to load", pageName);
        webElement.waitToBeVisible(timeOut);
        Logs.info("%s loaded successfully", pageName);
    }

    protected $ $(By locator) {
        return new $(locator, DEFAULT_TIME_OUT);
    }

    protected $$ $$(By locator) {
        return new $$(locator);
    }

    public void goToIndex() {
        Logs.info("Going to the main url");
        BaseTest.getDriver().get(mainUrl);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}
