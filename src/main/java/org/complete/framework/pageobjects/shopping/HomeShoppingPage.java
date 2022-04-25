package org.complete.framework.pageobjects.shopping;

import io.qameta.allure.Step;
import org.complete.framework.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeShoppingPage extends BasePage {
    private final By title = By.className("title");
    private final By filterSelect = By.cssSelector("select[data-test='product_sort_container']");
    private final By allPrices = By.className("inventory_item_price");
    private final By allNames = By.className("inventory_item_name");
    private final By robotImage = By.className("peek");
    private final By inventoryContainer = By.id("inventory_container");

    public HomeShoppingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting home shopping page to load")
    public void waitPageToLoad() {
        waitPage(inventoryContainer, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verifying home shopping page")
    public void verifyPage() {
        log.info("Verifying " + this.getClass().getSimpleName());
        softAssert.assertTrue(verifyIsDisplayed(title), "title is displayed");
        softAssert.assertTrue(verifyIsDisplayed(filterSelect), "filter select is displayed");
        softAssert.assertTrue(verifyIsDisplayed(robotImage), "robot image is displayed");
        softAssert.assertTrue(verifyIsDisplayed(inventoryContainer), "inventory container is displayed");
        softAssert.assertAll();
    }

    @Step("Filtering by name")
    public void filterByName(boolean isAscendant) {
        var select = getSelect(filterSelect);
        if (isAscendant) {
            log.info("Filter by name ascendant: AZ");
            select.selectByValue("az");
        } else {
            log.info("Filter by name descendant: ZA");
            select.selectByValue("za");
        }
    }

    @Step("Filtering by price")
    public void filterByPrice(boolean isAscendant) {
        var select = getSelect(filterSelect);
        if (isAscendant) {
            log.info("Filter by price ascendant: low -> high");
            select.selectByValue("lohi");
        } else {
            log.info("Filter by price descendant: high -> low");
            select.selectByValue("hilo");
        }
    }

    @Step("Verifying item price order")
    public void verifyItemPriceOrder(boolean isAscendant) {
        var listElements = findAllElements(allPrices);

        var firstItem =
                Double.parseDouble(listElements.get(0).getText().substring(1));
        var lastItem =
                Double.parseDouble(listElements.get(listElements.size() - 1).getText().substring(1));

        if (isAscendant) {
            log.info("Verifying item price order is ascendant: low -> high");
            Assert.assertTrue(firstItem < lastItem);
        } else {
            log.info("Verifying item price order is descendant: high -> low");
            Assert.assertTrue(firstItem > lastItem);
        }
    }

    @Step("Verifying item name order")
    public void verifyItemNameOrder(boolean isAscendant) {
        var listElements = findAllElements(allNames);

        var firstItem = listElements.get(0).getText();
        var lastItem = listElements.get(listElements.size() - 1).getText();

        if (isAscendant) {
            log.info("Verifying item name order is ascendant: AZ");
            Assert.assertTrue(firstItem.compareToIgnoreCase(lastItem) < 0);
        } else {
            log.info("Verifying item name order is descendant: ZA");
            Assert.assertTrue(firstItem.compareToIgnoreCase(lastItem) > 0);
        }
    }
}
