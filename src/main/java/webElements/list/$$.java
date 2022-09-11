package webElements.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.single.$;

import java.util.List;

public class $$ implements IListActions {
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
        var element = webElementList.get(index);
        return new $(element, driver);
    }

    public $ getFirst() {
        var element = webElementList.get(0);
        return new $(element, driver);
    }

    public $ getLast() {
        var element = webElementList.get(webElementList.size() - 1);
        return new $(element, driver);
    }

    @Override
    public void clickAll() {
        findList();
        for (var webElement : webElementList) {
            webElement.click();
        }
    }

    @Override
    public void sendKeysAll(String text) {
        findList();
        for (var webElement : webElementList) {
            webElement.sendKeys(text);
        }
    }
}
