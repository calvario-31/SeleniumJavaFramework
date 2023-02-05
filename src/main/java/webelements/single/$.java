package webelements.single;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import webelements.list.$$;

import java.time.Duration;

import static base.BasePage.DEFAULT_TIME_OUT;

public class $ {
    private WebElement webElement;
    private By locator;
    private WebDriverWait wait;
    private boolean searchForElement = true;
    private final int timeOut;

    public $(By locator, int timeOut) {
        this.locator = locator;
        this.timeOut = timeOut;
    }

    public $(WebElement webElement) { //init from list
        this.webElement = webElement;
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

    public boolean doesExists() {
        final var list = new $$(locator);
        return list.getSize() > 0;
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

    public $ waitToBeVisible(int timeOut) {
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); //explicit wait per se
        return this;
    }

    public $ waitToBeVisible() {
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));  //explicit wait per se
        return this;
    }

    public $ waitToBeClickable() {
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(locator));  //explicit wait per se
        return this;
    }

    private void findElement() {
        if (searchForElement) {
            webElement = BaseTest.getDriver().findElement(locator);
        }
    }

    private Select getSelect() {
        findElement();
        return new Select(webElement);
    }
}
