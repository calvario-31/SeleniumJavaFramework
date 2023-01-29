package webelements.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webelements.single.$;

import java.util.List;

public class $$ {
    private final By locator;
    private final WebDriver driver;
    private List<WebElement> webElementList;

    public $$(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    private void findList() {
        webElementList = driver.findElements(locator);
    }

    public $ getElementAtIndex(int index) {
        findList();
        final var element = webElementList.get(index);
        return new $(element, driver);
    }

    public $ getFirst() {
        return getElementAtIndex(0);
    }

    public $ getLast() {
        return getElementAtIndex(webElementList.size() - 1);
    }

    public void clickAll() {
        findList();
        for (var webElement : webElementList) {
            new $(webElement, driver).click();
        }
    }

    public void sendKeysAll(String text) {
        findList();
        for (var webElement : webElementList) {
            new $(webElement, driver).sendKeys(text);
        }
    }
}
