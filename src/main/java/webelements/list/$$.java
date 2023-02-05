package webelements.list;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webelements.single.$;

import java.util.List;

public class $$ {
    private final By locator;
    private List<WebElement> webElementList;

    public $$(By locator) {
        this.locator = locator;
    }

    private void findList() {
        webElementList = BaseTest.getDriver().findElements(locator);
    }

    public int getSize() {
        findList();
        return webElementList.size();
    }

    public $ getElementAtIndex(int index) {
        findList();
        final var element = webElementList.get(index);
        return new $(element);
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
            new $(webElement).click();
        }
    }

    public void sendKeysAll(String text) {
        findList();
        for (var webElement : webElementList) {
            new $(webElement).sendKeys(text);
        }
    }
}
