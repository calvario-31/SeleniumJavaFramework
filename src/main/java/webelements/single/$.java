package webelements.single;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static base.BasePage.DEFAULT_TIME_OUT;

public class $ {
    private WebElement webElement;
    private By locator;
    private final WebDriver driver;
    private WebDriverWait wait;
    private boolean searchForElement = true;
    private final int timeOut;

    public $(By locator, WebDriver driver, int timeOut) {
        this.locator = locator;
        this.driver = driver;
        this.timeOut = timeOut;
    }

    public $(WebElement webElement, WebDriver driver) { //init from list
        this.webElement = webElement;
        this.driver = driver;
        this.timeOut = DEFAULT_TIME_OUT;
        searchForElement = false; //we do not need to do findElement since is already init
    }

    public $ click() {
        findElement();
        webElement.click();
        return this;
    }

    public $ sendKeys(String text) {
        findElement();
        webElement.sendKeys(text);
        return this;
    }

    public boolean isDisplayed() {
        findElement();
        return webElement.isDisplayed();
    }

    public boolean isEnabled() {
        findElement();
        return webElement.isEnabled();
    }

    public boolean isSelected() {
        findElement();
        return webElement.isSelected();
    }

    public String getText() {
        findElement();
        return webElement.getText();
    }

    public String getHref() {
        findElement();
        return webElement.getAttribute("href");
    }

    public void selectByValue(String value) {
        final var select = getSelect();
        select.selectByValue(value);
    }

    public void selectByIndex(int index) {
        final var select = getSelect();
        select.selectByIndex(index);
    }

    public void selectByVisibleText(String text) {
        final var select = getSelect();
        select.selectByVisibleText(text);
    }

    public $ waitForVisibility(int timeOut) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); //explicit wait per se
        return this;
    }

    public $ waitForVisibility() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));  //explicit wait per se
        return this;
    }

    private void findElement() {
        if (searchForElement) {
            webElement = driver.findElement(locator);
        }
    }

    private Select getSelect() {
        findElement();
        return new Select(webElement);
    }
}
