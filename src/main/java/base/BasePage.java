package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String mainUrl = "https://www.saucedemo.com";
    private final int defaultTimeout = 5;
    protected final SoftAssert softAssert;
    protected final Logs log = new Logs();

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
    }

    protected BasePage(WebDriver driver, int timeOut) {
        this.driver = driver;
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAllElements(By locator) {
        return driver.findElements(locator);
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void typeText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected Select getSelect(By locator) {
        return new Select(findElement(locator));
    }

    protected String getHref(By locator) {
        return findElement(locator).getAttribute("href");
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    protected void waitWebElementVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean verifyIsDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    protected boolean verifyIsClickable(By locator) {
        return findElement(locator).isEnabled();
    }

    protected void waitPage(By locator, String pageName) {
        log.info("Waiting " + pageName + " to load");
        waitWebElementVisibility(locator);
        log.info(pageName + " loaded successfully");
    }

    public void goToIndex() {
        log.info("Going to the main url");
        driver.get(mainUrl);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}
